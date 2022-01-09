package com.youcode.gestionemployes.metier;

import com.youcode.gestionemployes.entity.Administrateur;
import com.youcode.gestionemployes.entity.Utilisateur;
import com.youcode.gestionemployes.repository.AdministrateurRepository;
import com.youcode.gestionemployes.repository.AdministrateurRepositoryImpl;

import java.util.Collection;

public class AdministrateurService extends UtilisateurService {
    private final AdministrateurRepository administrateurRepository;

    public AdministrateurService() {
        administrateurRepository = new AdministrateurRepositoryImpl();
    }

    @Override
    public Administrateur add(Utilisateur administrateur) {
        return administrateurRepository.save((Administrateur) administrateur);
    }

    @Override
    public Administrateur modify(Utilisateur administrateur) {
        return administrateurRepository.update((Administrateur) administrateur);
    }

    @Override
    public Administrateur get(Integer id) {
        return administrateurRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Administrateur> getAll() {
        return administrateurRepository.findAll();
    }

}
