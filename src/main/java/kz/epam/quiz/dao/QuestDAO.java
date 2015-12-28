package kz.epam.quiz.dao;

import kz.epam.quiz.entity.Quest;
import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.enums.TaskTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestDAO extends JpaRepository<Quest, Integer>{

    @Query(value = "SELECT q from Quest q where q.user = :user and q.task = :task")
    Quest findByUserAndTask(@Param("user") User user, @Param("task") TaskTypeEnum task);

    List<Quest> findByUser(User user);

//    List<Quest> findByTaskBeforeDate(@Param("task") TaskTypeEnum task, Date date);
}
