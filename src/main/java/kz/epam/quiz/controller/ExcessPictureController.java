package kz.epam.quiz.controller;

import kz.epam.quiz.dao.*;
import kz.epam.quiz.entity.ExcessImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/excess_image")
public class ExcessPictureController {

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

}
