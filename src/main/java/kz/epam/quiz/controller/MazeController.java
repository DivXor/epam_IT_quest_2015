package kz.epam.quiz.controller;

import kz.epam.quiz.dao.MazeDao;
import kz.epam.quiz.dao.MazeHistoryDAO;
import kz.epam.quiz.dao.QuestDAO;
import kz.epam.quiz.dao.UserDao;
import kz.epam.quiz.entity.Maze;
import kz.epam.quiz.entity.MazeHistory;
import kz.epam.quiz.entity.Quest;
import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.TaskTypeEnum;
import kz.epam.quiz.util.TaskHelper;
import kz.epam.quiz.util.maze.MazeJsonViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;
//TODO change return in method checkAnswer
@Controller
@RequestMapping(value = "/maze")
public class MazeController {
    public static final int CELL_SIZE = 17;
    public static final int CHARS_DISTANCE = 20;
    public static final int TEAM1_MAZE_ID = 1;
    public static final int TEAM2_MAZE_ID = 2;

    @Autowired
    private MazeDao mazeDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private MazeHistoryDAO mazeHistoryDAO;

    @Autowired
    private QuestDAO questDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String viewMaze(Model model) {
        return "maze";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String checkAnswer(@RequestParam(value = "answer") String answer,
                              RedirectAttributes redirectAttributes,
                              Principal principal) {
        String currentUser = principal.getName();
        User user = userDao.findUserByName(currentUser);
        Maze maze = getAssociatedMaze(currentUser);

        Quest currentQuest = questDAO.findByUserAndTask(user, TaskTypeEnum.MAZE);

        if (currentQuest == null || !currentQuest.isDone()){
            String dbAnswer = maze.getPassword().replaceAll("\\s+", "").toLowerCase();
            String userAnswer = answer.replaceAll("\\s+", "").toLowerCase();
            boolean isAnswerRight = dbAnswer.equals(userAnswer);

            if (isAnswerRight) {
                MazeHistory mazeHistory = new MazeHistory();
                mazeHistory.setUser(user);
                mazeHistory.setMaze(maze);
                mazeHistoryDAO.save(mazeHistory);

                Quest newQuest = new Quest(true, maze.getBaseScore(), user, TaskTypeEnum.MAZE);
                questDAO.save(newQuest);

                TaskHelper.setNextTask(user);
                userDao.save(user);

                return "redirect:/task";
            } else {
                redirectAttributes.addFlashAttribute("answerError", true);
                return "redirect:/task";
            }
        } else return "redirect:/task";

    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    public String getMazeData(Principal principal) throws IOException {
        String currentUser = principal.getName();
        Maze maze = getAssociatedMaze(currentUser);
        MazeJsonViewer jsonViewer = new MazeJsonViewer();
        return jsonViewer.createJsonMazeResponse(maze, CELL_SIZE, CHARS_DISTANCE).toString();
    }

    private Maze getAssociatedMaze(String userName){
        Maze maze;
        switch (userName){
            case "Team1":
                maze = mazeDao.findOne(TEAM1_MAZE_ID);
                break;
            case "Team2":
                maze = mazeDao.findOne(TEAM2_MAZE_ID);
                break;
            default:
                maze = mazeDao.findOne(TEAM1_MAZE_ID);
                break;
        }
        return maze;
    }
}
