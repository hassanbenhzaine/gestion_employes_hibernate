package com.youcode.gestionemployes.dao;

import com.youcode.gestionemployes.entity.Employe;
import com.youcode.gestionemployes.shared.EntityManagerFactoryProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class EmployeeDAOImpl implements GenericDAO<Employe, Integer> {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private final EntityManager entityManager;
    private final String tableName = "employes";

    public EmployeeDAOImpl() {
        EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().get();
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public void create(Employe employe) {
        entityManager.getTransaction().begin();
        entityManager.persist(employe);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Optional<Employe> get(Integer id) {
        entityManager.getTransaction().begin();
        Optional<Employe> employe = Optional
                .of(entityManager.find(Employe.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
        return employe;
    }

    @Override
    public Collection<Employe> getAll() {
        entityManager.getTransaction().begin();
        List<Employe> employeList = entityManager
                .createQuery("SELECT a FROM " + tableName + " a", Employe.class)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return employeList;
    }

    @Override
    public Employe update(Employe employe) {
        entityManager.getTransaction().begin();
        Employe updatedEmploye = entityManager.merge(employe);
        entityManager.getTransaction().commit();
        entityManager.close();
        return updatedEmploye;
    }

    @Override
    public void delete(Employe employe) {
        entityManager.getTransaction().begin();
        entityManager.remove(employe);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
