package kz.epam.quiz.controller;

import kz.epam.quiz.controller.dto.GrammarAnswersDTO;
import kz.epam.quiz.dao.GrammarQuizDao;
import kz.epam.quiz.dao.GrammarQuizHistoryDAO;
import kz.epam.quiz.entity.GrammarQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/grammar")
public class GrammarQuizController {

    @Autowired
    GrammarQuizDao dao;

    @Autowired
    GrammarQuizHistoryDAO historyDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String grammarPage(Model model) {
        List<GrammarQuiz> quizList = dao.findAll();
        model.addAttribute("grammarQuizzes", quizList);
        return "grammar";
    }

    @RequestMapping(value = "check", method = RequestMethod.POST)
    public String checkAnswers(@ModelAttribute GrammarAnswersDTO answersDTO, RedirectAttributes redirectAttributes) {
        boolean hasWrongAnswer = false;

        Map<String, String> answers = answersDTO.getAnswers();

        for (String id : answers.keySet()) {
            GrammarQuiz quiz = dao.findOne(Integer.parseInt(id));
            if (!answers.get(id).equals(quiz.getAnswer())){
                hasWrongAnswer = true;
            }
        }

        if (hasWrongAnswer){
            redirectAttributes.addFlashAttribute("answerError", true);
            return "redirect:/grammar";
        }

        return "finish";
    }

}
