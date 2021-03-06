package kz.epam.quiz.dao;

import kz.epam.quiz.config.AppConfig;
import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.UserRoleEnum;
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
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testFindAll() throws Exception {
        List<User> users = userDao.findAll();
        System.out.println(users);
    }

    @Test
    public void testFindUserByName() throws Exception {
        User user = userDao.findUserByName("Team1");
        System.out.println(user);
    }

    @Test
    public void testFindByRole() throws Exception {
        List<User> users = userDao.findByRole(UserRoleEnum.USER);
        System.out.println(users);
    }
}