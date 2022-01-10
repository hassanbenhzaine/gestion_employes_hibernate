package com.youcode.gestionemployes.metier;

import com.youcode.gestionemployes.entity.Administrateur;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class AdministrateurServiceTest {
    private AdministrateurService administrateurService;
    private static Administrateur testAdministrateur;

    @BeforeAll
    static void beforeAll() {
        testAdministrateur = Administrateur.builder()
                .email("email@gmail.com")
                .password("pass123")
                .firstName("hassan")
                .lastName("benhzaine")
                .dateOfBirth(LocalDate.now())
                .phone("0612345678")
                .status(true)
                .build();
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void add() {
    }

    @Test
    void modify() {
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }
}