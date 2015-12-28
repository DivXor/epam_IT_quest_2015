package kz.epam.quiz.controller;

import kz.epam.quiz.controller.dto.UserDTO;
import kz.epam.quiz.dao.QuestDAO;
import kz.epam.quiz.dao.UserDao;
import kz.epam.quiz.entity.Quest;
import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.UserRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
//todo create structure for DAO
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private QuestDAO questDAO;

//    @Autowired
//    private AssociationsHistoryDAO associationsHistoryDAO;
//    private ExcessImageHistoryDAO excessImageHistoryDAO;
//    private GrammarQuizHistoryDAO grammarQuizHistoryDAO;
//    private MazeHistoryDAO mazeHistoryDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String view(Model model) {
        List<UserDTO> userDTOs = new ArrayList<>();

        List<User> users = userDao.findByRole(UserRoleEnum.USER);

        for (User user : users){
            BigDecimal score = BigDecimal.ZERO;
            List<Quest> quests = questDAO.findByUser(user);

            for (Quest quest : quests) {
                score = score.add(quest.getScore());
            }
            UserDTO userDTO = new UserDTO(user.getName(), score, user.getCurrentTask());
            userDTOs.add(userDTO);
        }

        model.addAttribute("userDTOs", userDTOs);
        return "admin";
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String refresh(Model model) {
//        return null;
//    }

}
