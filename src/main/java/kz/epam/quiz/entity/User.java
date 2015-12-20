package kz.epam.quiz.entity;

import kz.epam.quiz.entity.enums.TaskTypeEnum;
import kz.epam.quiz.entity.enums.UserRoleEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User extends AbstractEntity implements Serializable {
    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "TASK_ID")
    private TaskTypeEnum currentTask;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    private Set<MazeHistory> mazeHistories;
//
//    public Set<MazeHistory> getMazeHistories() {
//        return mazeHistories;
//    }
//
//    public void setMazeHistories(Set<MazeHistory> mazeHistories) {
//        this.mazeHistories = mazeHistories;
//    }

    public User() {
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", currentTask=" + currentTask +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (role != user.role) return false;
        return currentTask == user.currentTask;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (currentTask != null ? currentTask.hashCode() : 0);
        return result;
    }
}