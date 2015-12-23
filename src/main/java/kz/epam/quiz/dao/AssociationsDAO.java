package kz.epam.quiz.dao;

import kz.epam.quiz.entity.Associations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationsDAO extends JpaRepository<Associations, Integer> {

}
