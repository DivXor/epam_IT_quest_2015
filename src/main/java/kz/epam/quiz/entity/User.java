package kz.epam.quiz.entity;

import kz.epam.quiz.entity.enums.UserRoleEnum;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity{
    private String name;
    private String password;

    private UserRoleEnum role;

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

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}