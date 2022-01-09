package com.youcode.gestionemployes.repository;

import com.youcode.gestionemployes.entity.Utilisateur;

import java.util.Collection;
import java.util.Optional;

public interface UtilisateurRepository {
    Utilisateur save(Utilisateur utilisateur);

    Collection<Utilisateur> findAll();

    Optional<Utilisateur> findById(Integer id);

    Utilisateur update(Utilisateur utilisateur);

    void delete(Utilisateur utilisateur);

    Optional<Utilisateur> findByEmailAndPassword(String email, String password);

}
