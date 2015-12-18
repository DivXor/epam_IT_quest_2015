package kz.epam.quiz.dao;

import kz.epam.quiz.entity.GrammarQuizHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrammarQuizHistoryDAO extends JpaRepository<GrammarQuizHistory, Integer>{
}
