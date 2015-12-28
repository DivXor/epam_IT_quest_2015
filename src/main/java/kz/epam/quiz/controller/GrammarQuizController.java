package kz.epam.quiz.controller;

import com.google.gson.JsonObject;
import kz.epam.quiz.controller.dto.GrammarAnswersDTO;
import kz.epam.quiz.dao.GrammarQuizDao;
import kz.epam.quiz.dao.GrammarQuizHistoryDAO;
import kz.epam.quiz.dao.QuestDAO;
import kz.epam.quiz.dao.UserDao;
import kz.epam.quiz.entity.GrammarQuiz;
import kz.epam.quiz.entity.GrammarQuizHistory;
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

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/grammar")
public class GrammarQuizController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private GrammarQuizDao dao;

    @Autowired
    private GrammarQuizHistoryDAO historyDAO;

    @Autowired
    private QuestDAO questDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String grammarPage(Model model) {
        List<GrammarQuiz> quizList = dao.findAll();
        model.addAttribute("grammarQuizzes", quizList);
        return "grammar";
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

        Quest currentQuest = questDAO.findByUserAndTask(user, TaskTypeEnum.GRAMMAR);

        if (currentQuest == null || !currentQuest.isDone()) {

            List<GrammarQuiz> quizList = dao.findAll();

            for (GrammarQuiz quiz : quizList) {
                String currentAnswer = answers.get(String.valueOf(quiz.getId()));
                GrammarQuizHistory quizHistory = historyDAO.findByUserAndQuiz(user, quiz);

                if (quizHistory == null)
                    quizHistory = new GrammarQuizHistory(currentAnswer, quiz, user);
                else quizHistory.setAnswer(currentAnswer);

                if (!currentAnswer.equals(quiz.getAnswer()))
                    hasWrongAnswer = true;
                else score = score.add(quiz.getBaseScore());

                historyDAO.save(quizHistory);
            }

            if (hasWrongAnswer) {
                jsonObject.addProperty("answerStatus", "error");
                jsonObject.addProperty("score", score);
            } else {
                Quest newQuest = new Quest(true, score, user, TaskTypeEnum.GRAMMAR);
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

        List<GrammarQuizHistory> historyList = historyDAO.findByUser(user);

        for (GrammarQuizHistory history : historyList) {
            String historyAnswer = history.getAnswer();
            String rightAnswer = history.getQuiz().getAnswer();

            if (historyAnswer.equals(rightAnswer)) {
                score = score.add(history.getQuiz().getBaseScore());
            }
        }

        Quest newQuest = new Quest(true, score, user, TaskTypeEnum.GRAMMAR);
        questDAO.save(newQuest);

        TaskHelper.setNextTask(user);
        userDao.save(user);
        return "redirect:/task";
    }

}
