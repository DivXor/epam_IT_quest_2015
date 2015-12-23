package kz.epam.quiz.util;

import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.TaskTypeEnum;

public abstract class TaskHelper {

    public static synchronized void setNextTask(User user){
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
                user.setCurrentTask(TaskTypeEnum.ASSOCIATIONS); //TODO изменить после того как доделаем ассоциации
                break;
            case ASSOCIATIONS:
                user.setCurrentTask(TaskTypeEnum.FINISH);
                break;
        }
    }

}
