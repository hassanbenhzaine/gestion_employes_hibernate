package com.youcode.gestionemployes.repository;

import com.youcode.gestionemployes.entity.Administrateur;
import com.youcode.gestionemployes.shared.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class AdministrateurRepositoryImpl implements AdministrateurRepository {
    private final EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();

    @Override
    public Administrateur save(Administrateur administrateur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(administrateur);
        em.getTransaction().commit();
        em.close();
        return administrateur;
    }

    @Override
    public Optional<Administrateur> findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Optional<Administrateur> administrateur = Optional
                .empty();
        em.find(Administrateur.class, id);
        em.close();
        return administrateur;
    }

    @Override
    public Collection<Administrateur> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Administrateur> administateurList = em
                .createNamedQuery("Administrateur.findAll", Administrateur.class)
                .getResultList();
        em.close();
        return administateurList;
    }

    @Override
    public Administrateur update(Administrateur administrateur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Administrateur updatedAdministrateur = em.merge(administrateur);
        em.getTransaction().commit();
        em.close();
        return updatedAdministrateur;
    }

    @Override
    public void delete(Administrateur administrateur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(administrateur);
        em.getTransaction().commit();
        em.close();
    }
}
