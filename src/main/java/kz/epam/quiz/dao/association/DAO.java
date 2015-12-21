package kz.epam.quiz.dao.association;

import java.util.List;

public interface DAO<T> {

    void create(T entity);

    void delete(int id);

    void update(T entity);

    T find(int id);

    List<T> getList(int number);

}
