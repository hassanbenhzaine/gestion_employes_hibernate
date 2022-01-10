package com.youcode.gestionemployes.metier;

import com.youcode.gestionemployes.entity.Utilisateur;
import com.youcode.gestionemployes.repository.UtilisateurRepository;
import com.youcode.gestionemployes.repository.UtilisateurRepositoryImpl;

import java.util.Collection;

public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService() {
        utilisateurRepository = new UtilisateurRepositoryImpl();
    }

    public Utilisateur add(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur modify(Utilisateur utilisateur) {
        return utilisateurRepository.update(utilisateur);
    }

    public void delete(Utilisateur utilisateur) {
        utilisateurRepository.delete(utilisateur);
    }

    public Utilisateur get(Integer id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public Collection<? extends Utilisateur> getAll() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur login(Utilisateur utilisateur) {
        return utilisateurRepository.findByEmailAndPassword(
                utilisateur.getEmail(), utilisateur.getPassword()).orElse(null);
    }
}
