package kz.epam.quiz.service;

import kz.epam.quiz.dao.UserDao;
import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.TaskTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void setNextTask(User user){
        TaskTypeEnum currentTask = user.getCurrentTask();
        switch (currentTask){
            case MAZE:
                user.setCurrentTask(TaskTypeEnum.WORD_SEARCH);
                break;
            case WORD_SEARCH:
                user.setCurrentTask(TaskTypeEnum.GRAMMAR);
                break;
            case GRAMMAR:
                user.setCurrentTask(TaskTypeEnum.FIND_SUPERFLUOUS);
                break;
            case FIND_SUPERFLUOUS:
                user.setCurrentTask(TaskTypeEnum.ASSOCIATIONS);
                break;
            case ASSOCIATIONS:
                user.setCurrentTask(TaskTypeEnum.FINISH);
                break;
        }
        userDao.save(user);
    }
}
