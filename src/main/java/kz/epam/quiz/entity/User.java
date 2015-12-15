package kz.epam.quiz.entity;

import kz.epam.quiz.entity.enums.TaskTypeEnum;
import kz.epam.quiz.entity.enums.UserRoleEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "USERS")
public class User extends AbstractEntity{
    private String name;
    private String password;

    @Column(name = "TOTAL_SCORE")
    private BigDecimal totalScore;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "TASKS_ID")
    private TaskTypeEnum currentTask;

    protected User() {
    }

    public User(String name, String password, UserRoleEnum role) {
        this.name = name;
        this.password = password;
        this.role = role;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public TaskTypeEnum getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(TaskTypeEnum currentTask) {
        this.currentTask = currentTask;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", totalScore=" + totalScore +
                ", role=" + role +
                ", currentTask=" + currentTask +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (totalScore != null ? !totalScore.equals(user.totalScore) : user.totalScore != null) return false;
        if (role != user.role) return false;
        return currentTask == user.currentTask;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (totalScore != null ? totalScore.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (currentTask != null ? currentTask.hashCode() : 0);
        return result;
    }
}