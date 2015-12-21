package kz.epam.quiz.dao.association;

import kz.epam.quiz.entity.AssociationGamePlate;
import kz.epam.quiz.entity.AssociationResult;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class GamePlateDAO implements DAO<AssociationGamePlate> {
    @Inject
    private DAO<AssociationResult> resultDAO;

    @PersistenceContext
    private EntityManager manager;

    public void create(AssociationGamePlate entity) {
        manager.persist(entity);
    }

    public void delete(int id) {
        AssociationGamePlate plate = find(id);
        manager.remove(plate);
    }

    public void update(AssociationGamePlate entity) {
        resultDAO.update(entity.getResult());
        manager.merge(entity);
    }

    public AssociationGamePlate find(int id) {
        return manager.find(AssociationGamePlate.class, id);
    }

    public List<AssociationGamePlate> getList(int number) {
        Query query = manager.createQuery("SELECT e FROM AssociationGamePlate e");
        query.setMaxResults(number);
        return query.getResultList();
    }
}