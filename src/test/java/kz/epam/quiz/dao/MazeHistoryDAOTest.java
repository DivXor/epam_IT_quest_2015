package kz.epam.quiz.dao;

import kz.epam.quiz.config.AppConfig;
import kz.epam.quiz.entity.Maze;
import kz.epam.quiz.entity.MazeHistory;
import kz.epam.quiz.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@Transactional
public class MazeHistoryDAOTest {

    @Autowired
    MazeHistoryDAO mazeHistoryDAO;

    @Autowired
    UserDao userDao;

    @Autowired
    MazeDao mazeDao;

    @Test
    @Rollback(value = false)
    public void testSave() throws Exception {
        MazeHistory mazeHistory = new MazeHistory();
        User user = userDao.findOne(1);
        Maze maze = mazeDao.findOne(1);

        mazeHistory.setUser(user);
        mazeHistory.setMaze(maze);

        System.out.println(mazeHistory);
        mazeHistoryDAO.save(mazeHistory);

    }
}