package kz.epam.quiz.dao.association;

import kz.epam.quiz.entity.AssociationResult;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ResultDAO implements DAO<AssociationResult> {

    @PersistenceContext
    private EntityManager manager;

    public void create(AssociationResult entity) {
        manager.persist(entity);
    }

    public void delete(int id) {
        AssociationResult plate = find(id);
        manager.remove(plate);
    }

    public void update(AssociationResult entity) {
        manager.merge(entity);
    }

    public AssociationResult find(int id) {
        return manager.find(AssociationResult.class, id);
    }

    public List<AssociationResult> getList(int number) {
        Query query = manager.createQuery("SELECT e FROM AssociationResult e");
        query.setMaxResults(number);
        return query.getResultList();
    }
}