package kz.epam.quiz.dao;

import kz.epam.quiz.config.AppConfig;
import kz.epam.quiz.entity.GrammarQuiz;
import kz.epam.quiz.entity.GrammarQuizHistory;
import kz.epam.quiz.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@Transactional
public class AssociationsHistoryDAOTest {

    @Autowired
    GrammarQuizHistoryDAO grammarQuizHistoryDAO;

    @Autowired
    UserDao userDao;

    @Autowired
    GrammarQuizDao grammarQuizDao;

    @Test
    public void testFindByUser() throws Exception {

    }

    @Test
    public void testFindByUserAndAssociations() throws Exception {
        GrammarQuiz quiz = grammarQuizDao.getOne(1);
        User user = userDao.findOne(1);
        GrammarQuizHistory grammarQuizHistory = grammarQuizHistoryDAO.findByUserAndQuiz(user, quiz);
        System.out.println(grammarQuizHistory);
    }
}