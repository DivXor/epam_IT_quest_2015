package kz.epam.quiz.controller;

import kz.epam.quiz.dao.CommentDAO;
import kz.epam.quiz.dao.QuestDAO;
import kz.epam.quiz.dao.UserDao;
import kz.epam.quiz.entity.Comment;
import kz.epam.quiz.entity.Quest;
import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.TaskTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/finish")
public class FinishController {
    public static final BigDecimal score = BigDecimal.ZERO;

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private UserDao userDao;

    @Autowired
    private QuestDAO questDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String view(Model model, Principal principal) {
        String userName = principal.getName();
        User user = userDao.findUserByName(userName);
        Quest quest = questDAO.findByUserAndTask(user, TaskTypeEnum.FINISH);

        if (quest == null){
            quest = new Quest(true,score, user, TaskTypeEnum.FINISH);
            questDAO.save(quest);
        }

        List<Comment> commentList = commentDAO.findAll();
        model.addAttribute("comments", commentList);
        return "finish";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendComment(@RequestParam("comment") String commentMessage, Principal principal, Model model) {
        String userName = principal.getName();
        User user = userDao.findUserByName(userName);

        if (commentMessage != null && !commentMessage.isEmpty()){
            Comment comment = new Comment();
            comment.setMessage(commentMessage);
            comment.setUser(user);
            commentDAO.save(comment);
        }

        return "redirect:/task";
    }

}
