package com.youcode.gestionemployes.repository;

import com.youcode.gestionemployes.dao.AdministrateurDAOImpl;
import com.youcode.gestionemployes.dao.GenericDAO;
import com.youcode.gestionemployes.entity.Administrateur;

import java.util.Collection;
import java.util.Optional;

public class AdministrateurRepositoryImpl implements AdministrateurRepository {
    private final GenericDAO<Administrateur, Integer> administrateurDAO;

    public AdministrateurRepositoryImpl() {
        this.administrateurDAO = new AdministrateurDAOImpl();
    }

    @Override
    public void save(Administrateur administrateur) {
        administrateurDAO.create(administrateur);
    }

    @Override
    public Collection<Administrateur> findAll() {
        return administrateurDAO.getAll();
    }

    @Override
    public Optional<Administrateur> findById(int id) {
        return administrateurDAO.get(id);
    }


    @Override
    public Administrateur update(Administrateur administrateur) {
        return administrateurDAO.update(administrateur);
    }

    @Override
    public void delete(Administrateur administrateur) {
        administrateurDAO.delete(administrateur);
    }

    @Override
    public Optional<Administrateur> findByEmailAndPassword(String email, String password) {
        return administrateurDAO.getAll().stream().parallel()
                .filter(a -> a.getEmail().equals(email) && a.getPassword().equals(password))
                .findAny();
    }
}
