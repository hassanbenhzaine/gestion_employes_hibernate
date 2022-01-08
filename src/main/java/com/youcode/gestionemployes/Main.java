package com.youcode.gestionemployes;

import com.youcode.gestionemployes.entity.Employe;
import com.youcode.gestionemployes.repository.EmployeRepository;
import com.youcode.gestionemployes.repository.EmployeRepositoryImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EmployeRepository employeRepository = new EmployeRepositoryImpl();
        employeRepository.save(Employe.builder()
                .dateOfBirth(LocalDate.now())
                .email("abc@gmail.com")
                .matricule("AD47890")
                .build()
        );


    }
}
