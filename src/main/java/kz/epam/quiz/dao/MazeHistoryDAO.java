package kz.epam.quiz.dao;

import kz.epam.quiz.entity.MazeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MazeHistoryDAO extends JpaRepository<MazeHistory, Integer> {
}
