package kz.epam.quiz.dao;

import kz.epam.quiz.entity.ExcessImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcessImageDAO extends JpaRepository<ExcessImage, Integer> {
}
