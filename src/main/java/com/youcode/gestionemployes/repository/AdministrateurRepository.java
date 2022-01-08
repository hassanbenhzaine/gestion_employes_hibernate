package com.youcode.gestionemployes.repository;

import com.youcode.gestionemployes.entity.Administrateur;

import java.util.Collection;
import java.util.Optional;

public interface AdministrateurRepository {
    void save(Administrateur administrateur);

    Collection<Administrateur> findAll();

    Optional<Administrateur> findById(int id);

    Administrateur update(Administrateur administrateur);

    void delete(Administrateur administrateur);

    Optional<Administrateur> findByEmailAndPassword(String email, String password);
}
