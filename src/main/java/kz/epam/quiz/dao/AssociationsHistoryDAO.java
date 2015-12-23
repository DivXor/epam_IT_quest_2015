package kz.epam.quiz.dao;

import kz.epam.quiz.entity.Associations;
import kz.epam.quiz.entity.AssociationsHistory;
import kz.epam.quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationsHistoryDAO extends JpaRepository<AssociationsHistory, Integer> {
    List<AssociationsHistory> findByUser(User user);
    AssociationsHistory findByUserAndAssociations(User user, Associations associations);
}
