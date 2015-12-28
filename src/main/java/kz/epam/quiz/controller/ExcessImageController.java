package kz.epam.quiz.controller;

import com.google.gson.JsonObject;
import kz.epam.quiz.controller.dto.GrammarAnswersDTO;
import kz.epam.quiz.dao.ExcessImageDAO;
import kz.epam.quiz.dao.ExcessImageHistoryDAO;
import kz.epam.quiz.dao.QuestDAO;
import kz.epam.quiz.dao.UserDao;
import kz.epam.quiz.entity.ExcessImage;
import kz.epam.quiz.entity.ExcessImageHistory;
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

    @Autowired
    private UserDao userDao;

    @Autowired
    private ExcessImageDAO excessImageDAO;

    @Autowired
    private ExcessImageHistoryDAO historyDAO;

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
    public String checkAnswers(@ModelAttribute GrammarAnswersDTO answersDTO, Principal principal) {
        boolean hasWrongAnswer = false;
        JsonObject jsonObject = new JsonObject();

        BigDecimal score = BigDecimal.ZERO;
        Map<String, String> answers = answersDTO.getAnswers();

        //get current logged in user
        String currentUser = principal.getName();
        User user = userDao.findUserByName(currentUser);

        Quest currentQuest = questDAO.findByUserAndTask(user, TaskTypeEnum.FIND_EXCESS);

        if (currentQuest == null || !currentQuest.isDone()) {

            List<ExcessImage> excessImages = excessImageDAO.findAll();

            for (ExcessImage quiz : excessImages) {
                String quizIdStr = String.valueOf(quiz.getId());
                Integer currentAnswer = Integer.valueOf(answers.get(quizIdStr));

                ExcessImageHistory quizHistory = historyDAO.findByUserAndQuiz(user, quiz);

                if (quizHistory == null)
                    quizHistory = new ExcessImageHistory(currentAnswer, quiz, user);
                else quizHistory.setAnswer(currentAnswer);

                if (!currentAnswer.equals(quiz.getExcessImageNumber()))
                    hasWrongAnswer = true;
                else score = score.add(quiz.getBaseScore());

                historyDAO.save(quizHistory);
            }

            if (hasWrongAnswer) {
                jsonObject.addProperty("answerStatus", "error");
                jsonObject.addProperty("score", score);
            } else {
                Quest newQuest = new Quest(true, score, user, TaskTypeEnum.FIND_EXCESS);
                questDAO.save(newQuest);

                TaskHelper.setNextTask(user);
                userDao.save(user);

                jsonObject.addProperty("answerStatus", "success");
            }
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "next", method = RequestMethod.GET)
    public String goNext(Principal principal) {
        BigDecimal score = BigDecimal.ZERO;

        //get current logged in user
        String currentUser = principal.getName();
        User user = userDao.findUserByName(currentUser);

        List<ExcessImageHistory> historyList = historyDAO.findByUser(user);

        for (ExcessImageHistory history : historyList) {
            Integer historyAnswer = history.getAnswer();
            Integer rightAnswer = history.getQuiz().getExcessImageNumber();

            if (historyAnswer.equals(rightAnswer)){
                score = score.add(history.getQuiz().getBaseScore());
            }
        }

        Quest newQuest = new Quest(true, score, user, TaskTypeEnum.FIND_EXCESS);
        questDAO.save(newQuest);

        TaskHelper.setNextTask(user);
        userDao.save(user);
        return "redirect:/task";
    }
}
