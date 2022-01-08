package com.youcode.gestionemployes.metier;

import com.youcode.gestionemployes.entity.Administrateur;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdministrateurServiceTest {
    private static Administrateur administrateur;
    private AdministrateurService administrateurService;

    @BeforeAll
    static void beforeAll() {
        administrateur = Administrateur.builder()
                .email("cbenhzaine@gmail.com")
                .password("123456")
                .firstName("coucou")
                .lastName("coucou 2")
                .dateOfBirth(LocalDate.now())
                .build();
    }

    @BeforeEach
    void setUp() {
        administrateurService = new AdministrateurService();
    }

    @Test
    void add() {
        // given
        // when
        administrateurService.add(administrateur);
        // then
        assertNotNull(administrateur);
    }

    @Test
    void modify() {
    }

    @Test
    void delete() {
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }

    @Test
    void login() {
        // given
        // when
        boolean isLoggedIn = administrateurService.login(administrateur);
        // then
        assertTrue(isLoggedIn);
    }
}