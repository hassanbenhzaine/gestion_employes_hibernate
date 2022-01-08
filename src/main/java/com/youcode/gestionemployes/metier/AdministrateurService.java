package com.youcode.gestionemployes.metier;

import com.youcode.gestionemployes.entity.Administrateur;
import com.youcode.gestionemployes.repository.AdministrateurRepository;
import com.youcode.gestionemployes.repository.AdministrateurRepositoryImpl;

import java.util.Collection;

public class AdministrateurService {
    private final AdministrateurRepository administrateurRepository;

    public AdministrateurService() {
        administrateurRepository = new AdministrateurRepositoryImpl();
    }

    public void add(Administrateur administrateur) {
        administrateurRepository.save(administrateur);
    }

    public Administrateur modify(Administrateur administrateur) {
        return administrateurRepository.update(administrateur);
    }

    public void delete(Administrateur administrateur) {
        administrateurRepository.delete(administrateur);
    }

    public Administrateur get(int id) {
        return administrateurRepository.findById(id).orElse(null);
    }

    public Collection<Administrateur> getAll() {
        return administrateurRepository.findAll();
    }

    public boolean login(Administrateur administrateur) {
        return administrateurRepository.findByEmailAndPassword(
                administrateur.getEmail(), administrateur.getPassword()
        ).isPresent();
    }

}
