package kz.epam.quiz.dao;

import kz.epam.quiz.entity.Maze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MazeDao extends JpaRepository<Maze, Integer>{
}
