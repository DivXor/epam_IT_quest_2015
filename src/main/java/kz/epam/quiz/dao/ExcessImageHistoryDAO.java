package kz.epam.quiz.dao;

import kz.epam.quiz.entity.ExcessImageHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcessImageHistoryDAO extends JpaRepository<ExcessImageHistory, Integer> {
}
