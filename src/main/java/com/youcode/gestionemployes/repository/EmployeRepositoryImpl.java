package com.youcode.gestionemployes.repository;

import com.youcode.gestionemployes.dao.EmployeeDAOImpl;
import com.youcode.gestionemployes.dao.GenericDAO;
import com.youcode.gestionemployes.entity.Employe;

import java.util.Collection;
import java.util.Optional;

public class EmployeRepositoryImpl implements EmployeRepository {
    private final GenericDAO<Employe, Integer> employeDAO;

    public EmployeRepositoryImpl() {
        this.employeDAO = new EmployeeDAOImpl();
    }

    @Override
    public void save(Employe employe) {
        employeDAO.create(employe);
    }

    @Override
    public Collection<Employe> findAll() {
        return employeDAO.getAll();
    }

    @Override
    public Optional<Employe> findById(int id) {
        return employeDAO.get(id);
    }


    @Override
    public Employe update(Employe employe) {
        return employeDAO.update(employe);
    }

    @Override
    public void delete(Employe employe) {
        employeDAO.delete(employe);
    }
}
