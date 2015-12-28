package kz.epam.quiz.dao;

import kz.epam.quiz.entity.ExcessImage;
import kz.epam.quiz.entity.ExcessImageHistory;
import kz.epam.quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcessImageHistoryDAO extends JpaRepository<ExcessImageHistory, Integer> {
    List<ExcessImageHistory> findByUser(User user);
    ExcessImageHistory findByUserAndQuiz(User user, ExcessImage quiz);
}
