package com.youcode.gestionemployes.metier;

import com.youcode.gestionemployes.entity.Employe;
import com.youcode.gestionemployes.entity.Utilisateur;
import com.youcode.gestionemployes.repository.EmployeRepository;
import com.youcode.gestionemployes.repository.EmployeRepositoryImpl;

import java.util.Collection;

public class EmployeService extends UtilisateurService {
    private final EmployeRepository employeRepository;

    public EmployeService() {
        employeRepository = new EmployeRepositoryImpl();
    }


    @Override
    public void delete(Utilisateur employe) {
        employeRepository.delete((Employe) employe);
    }

    @Override
    public Employe save(Utilisateur employe) {
        return employeRepository.save((Employe) employe);
    }

    @Override
    public Employe update(Utilisateur employe) {
        return employeRepository.update((Employe) employe);
    }

    @Override
    public Employe findById(Integer id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Employe> findAll() {
        return employeRepository.findAll();
    }

}
