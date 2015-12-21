package kz.epam.quiz.controller;

import kz.epam.quiz.entity.AssociationGamePlate;
import kz.epam.quiz.entity.AssociationResult;
import kz.epam.quiz.service.association.ServiceInterface;
import kz.epam.quiz.util.association.AnswerChecker;
import kz.epam.quiz.util.association.ScoreCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping({"/association"})
public class PicturesController {
    public static final String VIEW = "association";
    @Inject
    private ServiceInterface<AssociationGamePlate> gamePlateService;

    @RequestMapping({"", "/"})
    public String getPictures(HttpSession session) {
        List<AssociationGamePlate> list = gamePlateService.getList(5);
        session.setAttribute("pictureList", list);
        return VIEW;
    }

    @RequestMapping(value = "/answer", params = {"hint"})
    public String getHint(HttpSession session, HttpServletRequest request) {
        String hintName = request.getParameter("hint");
        String[] hints = hintName.split("Hint");
        int plateId = Integer.valueOf(hints[1]);
        AssociationGamePlate gamePlate = gamePlateService.find(plateId);
        AssociationResult result = gamePlate.getResult();
        int hintCounter = result.getHintCounter();
        hintCounter++;
        result.setHintCounter(hintCounter);
        gamePlate.setResult(result);
        gamePlateService.update(gamePlate);
        getPictures(session);
        return VIEW;
    }

    @RequestMapping(value = "/answer", params = {"submit", "userAnswer[]"})
    public String userAnswerCheck(HttpSession session, HttpServletRequest request) {
        AssociationGamePlate gamePlate;
        AnswerChecker checker = new AnswerChecker();
        String[] answers = request.getParameterValues("userAnswer[]");
        String[] plateIds = request.getParameterValues("plateId[]");
        for (int i = 0; i < plateIds.length; i++) {
            gamePlate = gamePlateService.find(Integer.valueOf(plateIds[i]));
            AssociationResult result = gamePlate.getResult();
            boolean checkAnswer = checker.checkAnswer(answers[i], gamePlate);
            result.setAnswerRight(checkAnswer);
            if (result.isAnswerRight()) {
                result.setScore(ScoreCounter.scoreCounter(result));
            }
            gamePlateService.update(gamePlate);
        }
        getPictures(session);
        return VIEW;
    }
}