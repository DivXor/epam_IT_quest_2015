package kz.epam.quiz.service.association;

import kz.epam.quiz.dao.association.DAO;
import kz.epam.quiz.entity.AssociationGamePlate;
import kz.epam.quiz.entity.AssociationResult;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class GamePlateService implements ServiceInterface<AssociationGamePlate> {
    @Inject
    private DAO<AssociationResult> resultDAO;
    @Inject
    private DAO<AssociationGamePlate> gamePlateDAO;

    public void create(AssociationGamePlate entity) {
        gamePlateDAO.create(entity);
    }

    public void delete(int id) {
        gamePlateDAO.delete(id);
    }

    public void update(AssociationGamePlate entity) {
        gamePlateDAO.update(entity);
    }

    public AssociationGamePlate find(int id) {
        AssociationGamePlate gamePlate = gamePlateDAO.find(id);
        resultDAO.find(gamePlate.getResult().getId());
        return gamePlate;
    }

    public List<AssociationGamePlate> getList(int number) {
        return gamePlateDAO.getList(number);
    }
}