package kz.epam.quiz.util;

import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.TaskTypeEnum;

public abstract class TaskHelper {

    public static synchronized void setNextTask(User user){
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
    }

}
