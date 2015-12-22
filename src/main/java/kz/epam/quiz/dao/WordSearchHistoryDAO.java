package kz.epam.quiz.dao;

import kz.epam.quiz.entity.WordSearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordSearchHistoryDAO extends JpaRepository<WordSearchHistory, Integer>{
}
