package kz.epam.quiz.dao;

import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findUserByName(String name);

    List<User> findByRole(UserRoleEnum role);
}
