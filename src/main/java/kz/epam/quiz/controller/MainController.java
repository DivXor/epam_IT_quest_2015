package kz.epam.quiz.controller;

import kz.epam.quiz.dao.UserDao;
import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.TaskTypeEnum;
import kz.epam.quiz.service.UserService;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewMain() {
        return "index";
    }

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public String viewCurrentTask(Principal principal) {
        String currentUser = principal.getName();
        User user = userDao.findUserByName(currentUser);
        TaskTypeEnum currentTask = user.getCurrentTask();

        switch (currentTask){
            case MAZE:
                return "forward:/maze";
            case GRAMMAR:
                return "forward:/grammar";
            case WORD_SEARCH:
                return "forward:/wordsearch/board/first";
            case ASSOCIATIONS:
                return "forward:/association";
            case FIND_EXCESS:
                return "forward:/excess_image";
            case FINISH:
                return "forward:/finish";
        }
        return "index";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "index";
    }

    @RequestMapping(value = "/task/next", method = RequestMethod.GET)
    public String finishPage(Principal principal) {
        User user = userDao.findUserByName(principal.getName());
        userService.setNextTask(user);
        return "redirect:/task";
    }

}
