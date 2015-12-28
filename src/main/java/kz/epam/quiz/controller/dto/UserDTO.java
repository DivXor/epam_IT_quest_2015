package kz.epam.quiz.controller.dto;

import kz.epam.quiz.entity.enums.TaskTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class UserDTO {
//    private String name;
//    private BigDecimal totalScore;
//    private TaskTypeEnum currentTask;
//}

public class UserDTO {
    private String name;
    private BigDecimal totalScore;
    private TaskTypeEnum currentTask;

    public UserDTO() {
    }

    public UserDTO(String name, BigDecimal totalScore, TaskTypeEnum currentTask) {
        this.name = name;
        this.totalScore = totalScore;
        this.currentTask = currentTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    public TaskTypeEnum getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(TaskTypeEnum currentTask) {
        this.currentTask = currentTask;
    }
}
