package kz.epam.quiz.dao;

import kz.epam.quiz.config.AppConfig;
import kz.epam.quiz.entity.Quest;
import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.TaskTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@Transactional
public class QuestDAOTest {

    @Autowired
    QuestDAO questDAO;

    @Autowired
    UserDao userDao;

    @Test
    public void testFindByUserIdAndTaskId() throws Exception {
        User user = userDao.findOne(1);

        Quest quest = questDAO.findByUserAndTask(user, TaskTypeEnum.MAZE);
        System.out.println(quest);
    }
}