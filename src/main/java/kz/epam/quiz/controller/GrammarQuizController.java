package kz.epam.quiz.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/grammar")
public class GrammarQuizController {

    public static final BigDecimal GRAMMAR_BASE_SCORE = new BigDecimal(1);

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
    public String checkAnswers(@ModelAttribute GrammarAnswersDTO answersDTO,
                               RedirectAttributes redirectAttributes, Principal principal) {
        boolean hasWrongAnswer = false;

        Map<String, String> answers = answersDTO.getAnswers();

        //get current logged in used
        String currentUser = principal.getName();
        User user = userDao.findUserByName(currentUser);

        //get quest
        Quest currentQuest = questDAO.findByUserAndTask(user, TaskTypeEnum.GRAMMAR);

        if (currentQuest == null || !currentQuest.isDone()) {

            for (String id : answers.keySet()) {
                GrammarQuiz quiz = dao.findOne(Integer.parseInt(id));
                if (!answers.get(id).equals(quiz.getAnswer())) {
                    hasWrongAnswer = true;
                }
            }

            if (hasWrongAnswer) {
                redirectAttributes.addFlashAttribute("answerError", true);
            } else {
                Quest newQuest = new Quest(true, GRAMMAR_BASE_SCORE, user, TaskTypeEnum.GRAMMAR);
                questDAO.save(newQuest);

                TaskHelper.setNextTask(user);
                userDao.save(user);
            }
        }
        return "redirect:/task";
    }
}
