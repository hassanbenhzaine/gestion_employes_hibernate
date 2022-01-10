package com.youcode.gestionemployes.dao;

import com.youcode.gestionemployes.entity.Utilisateur;
import com.youcode.gestionemployes.shared.EntityManagerFactoryProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class UtilisateurDAOImpl implements GenericDAO<Utilisateur, Integer> {
    private final EntityManager em;

    public UtilisateurDAOImpl() {
        EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().get();
        this.em = emf.createEntityManager();
    }

    @Override
    public Utilisateur create(Utilisateur utilisateur) {
        em.getTransaction().begin();
        em.persist(utilisateur);
        em.getTransaction().commit();
        em.close();
        return utilisateur;
    }

    @Override
    public Optional<Utilisateur> get(Integer id) {
        Optional<Utilisateur> utilisateur = Optional
                .empty();
        em.find(Utilisateur.class, id);
        em.close();
        return utilisateur;
    }

    @Override
    public Collection<Utilisateur> getAll() {
        List<Utilisateur> utilisateurList = em
                .createNamedQuery("Utilisateur.findAll", Utilisateur.class)
                .getResultList();
        em.close();
        return utilisateurList;


    }

    @Override
    public Utilisateur update(Utilisateur utilisateur) {
        em.getTransaction().begin();
        Utilisateur updatedEmploye = em.merge(utilisateur);
        em.getTransaction().commit();
        em.close();
        return updatedEmploye;
    }

    @Override
    public void delete(Utilisateur utilisateur) {
        em.getTransaction().begin();
        em.remove(utilisateur);
        em.getTransaction().commit();
        em.close();
    }
}
