package kz.epam.quiz.controller;

import kz.epam.quiz.controller.dto.GrammarAnswersDTO;
import kz.epam.quiz.dao.ExcessImageDAO;
import kz.epam.quiz.dao.ExcessImageHistoryDAO;
import kz.epam.quiz.dao.QuestDAO;
import kz.epam.quiz.dao.UserDao;
import kz.epam.quiz.entity.ExcessImage;
import kz.epam.quiz.entity.Quest;
import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.TaskTypeEnum;
import kz.epam.quiz.util.TaskHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/excess_image")
public class ExcessImageController {

    public static final BigDecimal EXCESS_IMAGE_BASE_SCORE = new BigDecimal(1);

    @Autowired
    private UserDao userDao;

    @Autowired
    private ExcessImageDAO excessImageDAO;

    @Autowired
    private ExcessImageHistoryDAO excessImageHistoryDAO;

    @Autowired
    private QuestDAO questDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String viewMaze(Model model) {
        List<ExcessImage> excessImageQuests = excessImageDAO.findAll();
        model.addAttribute("imageQuizzes", excessImageQuests);
        return "excess_image";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public String checkAnswers(@ModelAttribute GrammarAnswersDTO answersDTO,
                               RedirectAttributes redirectAttributes, Principal principal) {
        boolean hasWrongAnswer = false;
        Map<String, String> answers = answersDTO.getAnswers();

        //get current logged in user
        String currentUser = principal.getName();
        User user = userDao.findUserByName(currentUser);

        //get quest
        Quest currentQuest = questDAO.findByUserAndTask(user, TaskTypeEnum.FIND_SUPERFLUOUS);

        if (currentQuest == null || !currentQuest.isDone()) {

            for (String id : answers.keySet()) {
                int currentAnswer = Integer.parseInt(answers.get(id));
                ExcessImage excessImage = excessImageDAO.findOne(Integer.parseInt(id));
                if (currentAnswer != excessImage.getExcessImageNumber()) {
                    hasWrongAnswer = true;
                }
            }

            if (hasWrongAnswer) {
                return "error";
            } else {
                Quest newQuest = new Quest(true, EXCESS_IMAGE_BASE_SCORE, user, TaskTypeEnum.FIND_SUPERFLUOUS);
                questDAO.save(newQuest);

                TaskHelper.setNextTask(user);
                userDao.save(user);
            }
        }
        return "success";
    }
//TODO what is it   >>
//    @RequestMapping(value = "/check", method = RequestMethod.POST)
//    public String checkAnswers(@ModelAttribute GrammarAnswersDTO answersDTO,
//                               RedirectAttributes redirectAttributes, Principal principal) {
//        boolean hasWrongAnswer = false;
//
//        Map<String, String> answers = answersDTO.getAnswers();
//
//        //get current logged in user
//        String currentUser = principal.getName();
//        User user = userDao.findUserByName(currentUser);
//
//        //get quest
//        Quest currentQuest = questDAO.findByUserAndTask(user, TaskTypeEnum.FIND_SUPERFLUOUS);
//
//        if (currentQuest == null || !currentQuest.isDone()) {
//
//            for (String id : answers.keySet()) {
//                int currentAnswer = Integer.parseInt(answers.get(id));
//                ExcessImage excessImage = excessImageDAO.findOne(Integer.parseInt(id));
//                if (currentAnswer != excessImage.getExcessImageNumber()) {
//                    hasWrongAnswer = true;
//                }
//            }
//
//            if (hasWrongAnswer) {
//                redirectAttributes.addFlashAttribute("answerError", true);
//            } else {
//                Quest newQuest = new Quest(true, EXCESS_IMAGE_BASE_SCORE, user, TaskTypeEnum.FIND_SUPERFLUOUS);
//                questDAO.save(newQuest);
//
//                TaskHelper.setNextTask(user);
//                userDao.save(user);
//            }
//        }
//        return "redirect:/task";
//    }

}
