package com.youcode.gestionemployes.metier;

import com.youcode.gestionemployes.entity.Employe;
import com.youcode.gestionemployes.repository.EmployeRepository;
import com.youcode.gestionemployes.repository.EmployeRepositoryImpl;

import java.util.Collection;

public class EmployeService {
    private final EmployeRepository employeRepository;

    public EmployeService() {
        employeRepository = new EmployeRepositoryImpl();
    }


    public void add(Employe employe) {
        employeRepository.save(employe);
    }

    public Employe modify(Employe employe) {
        return employeRepository.update(employe);
    }

    public void delete(Employe employe) {
        employeRepository.delete(employe);
    }

    public Employe get(int id) {
        return employeRepository.findById(id).orElse(null);
    }

    public Collection<Employe> getAll() {
        return employeRepository.findAll();
    }

}
