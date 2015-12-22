package kz.epam.quiz.controller;

import kz.epam.quiz.dao.QuestDAO;
import kz.epam.quiz.dao.UserDao;
import kz.epam.quiz.entity.Quest;
import kz.epam.quiz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@ControllerAdvice
public class ControllerHelper {

    @Autowired
    private QuestDAO questDAO;

    @Autowired
    private UserDao userDao;

    @ModelAttribute
    public void addUserSore(Model model, Principal principal){

        if (principal != null){
            BigDecimal score = new BigDecimal(0);
            String username = principal.getName();

            if (username != null && !username.isEmpty()) {
                User user = userDao.findUserByName(username);
                List<Quest> quests = questDAO.findByUser(user);

                for (Quest quest : quests) {
                    score.add(quest.getScore());
                }

                model.addAttribute("user", user);
                model.addAttribute("userScore", score.toString());
            }
        }
//
//        model.addAttribute("userScore", score);

    }
}
