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
            case GRAMMAR:
                user.setCurrentTask(TaskTypeEnum.FIND_EXCESS);
                break;
            case FIND_EXCESS:
                user.setCurrentTask(TaskTypeEnum.WORD_SEARCH);
                break;
            case WORD_SEARCH:
                user.setCurrentTask(TaskTypeEnum.MAZE);
                break;
            case MAZE:
                user.setCurrentTask(TaskTypeEnum.ASSOCIATIONS);
                break;
            case ASSOCIATIONS:
                user.setCurrentTask(TaskTypeEnum.FINISH);
                break;
        }
        userDao.save(user);
    }
}
