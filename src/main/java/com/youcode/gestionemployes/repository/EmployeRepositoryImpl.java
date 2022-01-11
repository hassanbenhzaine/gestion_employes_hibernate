package com.youcode.gestionemployes.repository;

import com.youcode.gestionemployes.entity.Employe;
import com.youcode.gestionemployes.shared.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class EmployeRepositoryImpl implements EmployeRepository {
    private final EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();

    @Override
    public Employe save(Employe employe) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(employe);
        em.getTransaction().commit();
        em.close();
        return employe;
    }

    @Override
    public Optional<Employe> findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Optional<Employe> employe = Optional
                .empty();
        em.find(Employe.class, id);
        em.close();
        return employe;
    }

    @Override
    public Collection<Employe> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Employe> employeList = em
                .createNamedQuery("Employe.findAll", Employe.class)
                .getResultList();
        em.close();
        return employeList;
    }

    @Override
    public Employe update(Employe employe) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Employe updatedEmploye = em.merge(employe);
        em.getTransaction().commit();
        em.close();
        return updatedEmploye;
    }

    @Override
    public void delete(Employe employe) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(employe);
        em.getTransaction().commit();
        em.close();
    }
}
