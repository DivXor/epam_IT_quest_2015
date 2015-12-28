package kz.epam.quiz.controller;

import kz.epam.quiz.controller.dto.AssociationDTO;
import kz.epam.quiz.dao.AssociationsDAO;
import kz.epam.quiz.dao.AssociationsHistoryDAO;
import kz.epam.quiz.dao.QuestDAO;
import kz.epam.quiz.dao.UserDao;
import kz.epam.quiz.entity.Associations;
import kz.epam.quiz.entity.AssociationsHistory;
import kz.epam.quiz.entity.Quest;
import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.TaskTypeEnum;
import kz.epam.quiz.util.TaskHelper;
import kz.epam.quiz.util.association.AnswerChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/association")
public class AssociationsController {
    public static final String VIEW = "association";

    @Autowired
    private AssociationsDAO associationsDAO;

    @Autowired
    private AssociationsHistoryDAO associationsHistoryDAO;

    @Autowired
    private UserDao userDao;

    @Autowired
    private QuestDAO questDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String getPictures(Model model, Principal principal) {
        List<AssociationDTO> dtoList = new ArrayList<>();

        String currentUser = principal.getName();
        User user = userDao.findUserByName(currentUser);

        List<Associations> associationsList = associationsDAO.findAll();
//todo will think about builder
//todo a lot of magic numbers
        for (Associations association : associationsList) {
            AssociationsHistory history = associationsHistoryDAO.findByUserAndAssociations(user, association);

            if (history != null) {
                AssociationDTO dto = new AssociationDTO(
                        association.getId(),
                        association.getImg1(), association.getImg2(), association.getImg3(), association.getImg4(),
                        history.getHintCounter(),
                        history.isAnswerRight(),
                        association.getHiddenWord(), association.getCategory());
                dtoList.add(dto);
            } else {
                AssociationDTO dto = new AssociationDTO(
                        association.getId(),
                        association.getImg1(), association.getImg2(), association.getImg3(), association.getImg4(),
                        0,
                        false,
                        association.getHiddenWord(),
                        association.getCategory());
                dtoList.add(dto);
            }
        }

        model.addAttribute("pictureList", dtoList);
        return VIEW;
    }

    @RequestMapping(value = "/hint/{id}")
    public String userHint(@PathVariable String id, Principal principal) {
        int associationId = Integer.parseInt(id);
        int initialScore = 0;

        Associations associations = associationsDAO.findOne(associationId);

        String currentUser = principal.getName();
        User user = userDao.findUserByName(currentUser);
//todo what are magic numbers?
        AssociationsHistory history = associationsHistoryDAO.findByUserAndAssociations(user, associations);
        if (history == null) {
            history = new AssociationsHistory(initialScore, false, associations, user);
        }
        history.setHintCounter(history.getHintCounter() + 1);
        associationsHistoryDAO.save(history);

        return "redirect:/task";
    }


    @RequestMapping(value = "/check/{id}", method = RequestMethod.POST)
    public String answerCheck(@RequestParam("userAnswer") String answer,
                              @PathVariable String id, RedirectAttributes redirectAttributes, Principal principal) {
        int associationId = Integer.parseInt(id);
        Associations associations = associationsDAO.findOne(associationId);

        String currentUser = principal.getName();
        User user = userDao.findUserByName(currentUser);

        AssociationsHistory history = associationsHistoryDAO.findByUserAndAssociations(user, associations);

        if (history == null) {
            history = new AssociationsHistory(0, false, associations, user);
        }

        AnswerChecker checker = new AnswerChecker();
        boolean checkAnswer = checker.checkAnswer(answer, associations);
        history.setAnswerRight(checkAnswer);

        associationsHistoryDAO.save(history);

        if (checkAnswer) {
            boolean questDone = true;

            //getting quest for current quiz and user
            Quest currentQuest = questDAO.findByUserAndTask(user, TaskTypeEnum.ASSOCIATIONS);
            if (currentQuest == null) {
                currentQuest = new Quest(false, BigDecimal.ZERO, user, TaskTypeEnum.ASSOCIATIONS);
            }

            BigDecimal score = currentQuest.getScore();
            score = score.add(scoreCounter(associations.getBaseScore(), history.getHintCounter()));
            currentQuest.setScore(score);

            List<Associations> associationsList = associationsDAO.findAll();

            for (Associations association : associationsList) {
                AssociationsHistory associationHistory = associationsHistoryDAO.findByUserAndAssociations(user, association);

                if (associationHistory == null)
                    questDone = false;
                else if (!associationHistory.isAnswerRight())
                    questDone = false;
            }

            currentQuest.setDone(questDone);

            if (currentQuest.isDone()) {
                TaskHelper.setNextTask(user);
            }

            userDao.save(user);
            questDAO.save(currentQuest);
        } else {
            redirectAttributes.addFlashAttribute("error", associationId);
        }
        return "redirect:/task";
    }

    //todo what are magic numbers?
    public BigDecimal scoreCounter(BigDecimal baseScore, int hintCounter) {
        assert baseScore.doubleValue() >= 1;
        double score = baseScore.doubleValue() - 0.25 * hintCounter;
        return new BigDecimal(score);
    }

}