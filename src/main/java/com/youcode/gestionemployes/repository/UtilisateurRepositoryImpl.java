package com.youcode.gestionemployes.repository;

import com.youcode.gestionemployes.dao.GenericDAO;
import com.youcode.gestionemployes.dao.UtilisateurDAOImpl;
import com.youcode.gestionemployes.entity.Utilisateur;

import java.util.Collection;
import java.util.Optional;

public class UtilisateurRepositoryImpl implements UtilisateurRepository {
    private final GenericDAO<Utilisateur, Integer> utilisateurDAO;

    public UtilisateurRepositoryImpl() {
        this.utilisateurDAO = new UtilisateurDAOImpl();
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
        return utilisateurDAO.getAll().stream().parallel()
                .filter(a -> a.getEmail().equals(email) && a.getPassword().equals(password))
                .findAny();
    }
}
