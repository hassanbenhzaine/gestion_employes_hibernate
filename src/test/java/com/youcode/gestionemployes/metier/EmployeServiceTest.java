package com.youcode.gestionemployes.metier;

import com.youcode.gestionemployes.entity.Employe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeServiceTest {
    private EmployeService employeService;
    private Employe testEmploye;

    @BeforeEach
    void setUp() {
        employeService = new EmployeService();
        testEmploye = Employe.builder()
                .email("email@gmailx.com")
                .password("pass123")
                .firstName("hassan")
                .lastName("benhzaine")
                .dateOfBirth(LocalDate.now())
                .phone("0612345678")
                .status(true)
                .matricule("AE68968")
                .salaire(8000D)
                .build();
    }

    @Test
    void add() {
        // given
        // when
        employeService.add(testEmploye);
        // then
//        assertTrue(testEmploye.getId() > 0);
    }

    @Test
    void modify() {
        // given
        testEmploye = employeService.getAll().stream().findAny().orElse(null);
//        testEmploye.setMatricule("AE00011");
//        testEmploye.setPassword("pass1234");
        // when
        employeService.modify(testEmploye);
        // then
        assertTrue(testEmploye.getMatricule().equals("AE00011")
                && testEmploye.getPassword().equals("pass1234"));
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
        // given
        // when
        employeService.getAll();
    }
}