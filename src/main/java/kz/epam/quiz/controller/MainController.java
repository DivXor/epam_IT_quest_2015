package kz.epam.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewMain(Model model) {
        return "index";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "index";
    }

    @RequestMapping(value = "/maze", method = RequestMethod.GET)
    public String viewMaze(Model model) {
        return "maze";
    }

    @RequestMapping(value = "/finish", method = RequestMethod.GET)
    public String finishPage(Model model) {
        return "finish";
    }

}
