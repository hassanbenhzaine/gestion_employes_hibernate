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
    public void delete(Utilisateur administrateur) {
        administrateurRepository.delete((Administrateur) administrateur);
    }

    @Override
    public Administrateur save(Utilisateur administrateur) {
        return administrateurRepository.save((Administrateur) administrateur);
    }

    @Override
    public Administrateur update(Utilisateur administrateur) {
        return administrateurRepository.update((Administrateur) administrateur);
    }

    @Override
    public Administrateur findById(Integer id) {
        return administrateurRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Administrateur> findAll() {
        return administrateurRepository.findAll();
    }

}
