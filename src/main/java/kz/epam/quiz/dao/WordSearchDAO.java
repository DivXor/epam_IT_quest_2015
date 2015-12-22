package kz.epam.quiz.dao;

import kz.epam.quiz.entity.WordSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordSearchDAO extends JpaRepository<WordSearch, Integer>{
}
