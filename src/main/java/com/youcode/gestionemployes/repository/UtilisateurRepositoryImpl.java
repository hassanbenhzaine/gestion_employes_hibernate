package com.youcode.gestionemployes.repository;

import com.youcode.gestionemployes.dao.GenericDAO;
import com.youcode.gestionemployes.dao.UtilisateurDAOImpl;
import com.youcode.gestionemployes.entity.Utilisateur;
import com.youcode.gestionemployes.shared.EntityManagerFactoryProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Collection;
import java.util.Optional;

public class UtilisateurRepositoryImpl implements UtilisateurRepository {
    private final GenericDAO<Utilisateur, Integer> utilisateurDAO;
    private final EntityManager entityManager;

    public UtilisateurRepositoryImpl() {
        this.utilisateurDAO = new UtilisateurDAOImpl();
        EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().get();
        entityManager = emf.createEntityManager();
    }

    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        utilisateurDAO.create(utilisateur);
        return utilisateur;
    }

    @Override
    public Collection<Utilisateur> findAll() {
        return utilisateurDAO.getAll();
    }

    @Override
    public Optional<Utilisateur> findById(Integer id) {
        return utilisateurDAO.get(id);
    }


    @Override
    public Utilisateur update(Utilisateur utilisateur) {
        return utilisateurDAO.update(utilisateur);
    }

    @Override
    public void delete(Utilisateur utilisateur) {
        utilisateurDAO.delete(utilisateur);
    }

    @Override
    public Optional<Utilisateur> findByEmailAndPassword(String email, String password) {
        return entityManager
                .createNamedQuery("Utilisateur.findByEmailAndPassword", Utilisateur.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList().stream().findFirst();
    }
}
