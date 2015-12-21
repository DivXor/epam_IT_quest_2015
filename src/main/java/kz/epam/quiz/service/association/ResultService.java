package kz.epam.quiz.service.association;

import kz.epam.quiz.dao.association.DAO;
import kz.epam.quiz.entity.AssociationResult;

import javax.inject.Inject;
import java.util.List;

public class ResultService implements ServiceInterface<AssociationResult> {

    @Inject
    private DAO<AssociationResult> resultDAO;

    public void create(AssociationResult entity) {
        resultDAO.create(entity);
    }

    public void delete(int id) {
        resultDAO.delete(id);
    }

    public void update(AssociationResult entity) {
        resultDAO.update(entity);
    }

    public AssociationResult find(int id) {
        return resultDAO.find(id);
    }

    public List<AssociationResult> getList(int number) {
        return resultDAO.getList(number);
    }
}