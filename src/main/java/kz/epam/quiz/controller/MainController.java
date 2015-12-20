package kz.epam.quiz.controller;

import kz.epam.quiz.dao.UserDao;
import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.TaskTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewMain(Model model) {
        return "index";
    }

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public String viewCurrentTask(Model model, Principal principal) {
        String currentUser = principal.getName();
        User user = userDao.findUserByName(currentUser);
        TaskTypeEnum currentTask = user.getCurrentTask();

        switch (currentTask){
            case MAZE:
                return "maze";
            case GRAMMAR:
                return "grammar";
            case ASSOCIATIONS:
                return "ASSOCIATIONS";
            case WORD_SEARCH:
                return "word_search";
            case FIND_SUPERFLUOUS:
                return "find_superfluous";
        }
        return "index";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "index";
    }

    @RequestMapping(value = "/finish", method = RequestMethod.GET)
    public String finishPage(Model model) {
        return "finish";
    }

}
