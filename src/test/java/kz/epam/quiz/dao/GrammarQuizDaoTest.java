package kz.epam.quiz.dao;

import kz.epam.quiz.config.AppConfig;
import kz.epam.quiz.entity.GrammarQuiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@Transactional
public class GrammarQuizDaoTest {

    @Autowired
    GrammarQuizDao quizDao;

    @Test
    public void testFindAll() throws Exception {
        List<GrammarQuiz> quizs = quizDao.findAll();
        System.out.println(quizs);
    }
}