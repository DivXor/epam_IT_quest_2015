package kz.epam.quiz.dao;

import kz.epam.quiz.entity.GrammarQuiz;
import kz.epam.quiz.entity.GrammarQuizHistory;
import kz.epam.quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrammarQuizHistoryDAO extends JpaRepository<GrammarQuizHistory, Integer>{
    List<GrammarQuizHistory> findByUser(User user);
    GrammarQuizHistory findByUserAndQuiz(User user, GrammarQuiz quiz);
}
