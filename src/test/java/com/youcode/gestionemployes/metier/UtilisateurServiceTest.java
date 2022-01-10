package com.youcode.gestionemployes.metier;

import com.youcode.gestionemployes.entity.Utilisateur;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurServiceTest {
    private static Utilisateur randomUtilisateur;
    private UtilisateurService utilisateurService;
    private Utilisateur testUtilisateur;

    @BeforeAll
    static void beforeAll() {
        randomUtilisateur = new UtilisateurService().getAll()
                .stream().parallel().findAny().orElse(null);
    }

    @BeforeEach
    void setUp() {
        this.utilisateurService = new UtilisateurService();
        testUtilisateur = Utilisateur.builder()
                .email("email@gmail.com")
                .password("pass123")
                .firstName("hassan")
                .lastName("benhzaine")
                .dateOfBirth(LocalDate.now())
                .phone("0612345678")
                .status(true)
                .build();
    }

    @Test
    void add() {
        // given
        // when
        utilisateurService.add(testUtilisateur);
        Utilisateur retreivedUtilisateur = utilisateurService.get(testUtilisateur.getId());
        // then
        assertEquals(testUtilisateur, retreivedUtilisateur);
    }

    @Test
    void modify() {
    }

    @Test
    void get() {
        // given
        // when
        Utilisateur utilisateur = utilisateurService.get(randomUtilisateur.getId());
        // then
        assertEquals(randomUtilisateur, utilisateur);
    }

    @Test
    void getAll() {
        //given
        //when
        int size = utilisateurService.getAll().size();
        //then
        assertTrue(size > 0);
    }

    @Test
    void login() {
        // given

        // when
//        boolean isLoggedIn = utilisateurService.login(testUtilisateur);
        // then
//        assertTrue(isLoggedIn);
    }

    @Test
    void delete() {
        // given
        // when
        utilisateurService.delete(randomUtilisateur);
        // then
        assertNull(utilisateurService.get(randomUtilisateur.getId()));
    }
}