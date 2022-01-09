package com.youcode.gestionemployes.repository;

import com.youcode.gestionemployes.entity.Employe;

import java.util.Collection;
import java.util.Optional;

public interface EmployeRepository {
    Employe save(Employe employe);

    Collection<Employe> findAll();

    Optional<Employe> findById(Integer id);

    Employe update(Employe employe);

    void delete(Employe employe);
}
