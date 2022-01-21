package com.youcode.gestionemployes.repository;

import com.youcode.gestionemployes.entity.Utilisateur;
import com.youcode.gestionemployes.shared.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class UtilisateurRepositoryImpl implements IUtilisateurRepository {
    private final EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();

    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(utilisateur);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return utilisateur;
    }

    @Override
    public Optional<Utilisateur> findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Optional<Utilisateur> utilisateur = Optional.ofNullable(em.find(Utilisateur.class, id));
        em.close();
        return utilisateur;
    }

    @Override
    public Collection<Utilisateur> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Utilisateur> utilisateurList = em
                .createNamedQuery("Utilisateur.findAll", Utilisateur.class)
                .getResultList();
        em.close();
        return utilisateurList;
    }

    @Override
    public Utilisateur update(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(utilisateur);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return utilisateur;
    }

    @Override
    public void delete(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(utilisateur));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<Utilisateur> findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Optional<Utilisateur> utilisateur = em.createNamedQuery("Utilisateur.findByEmail", Utilisateur.class)
                .setParameter("email", email)
                .getResultStream().findFirst();
        em.close();
        return utilisateur;
    }
}
