package kz.epam.quiz.dao;

import kz.epam.quiz.entity.GrammarQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrammarQuizDao extends JpaRepository<GrammarQuiz, Integer> {
}
