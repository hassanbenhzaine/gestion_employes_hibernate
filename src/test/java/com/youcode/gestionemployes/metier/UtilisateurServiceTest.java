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
        randomUtilisateur = new UtilisateurService().findAll()
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
    void save() {
        // given
        // when
        utilisateurService.save(testUtilisateur);
        Utilisateur retreivedUtilisateur = utilisateurService.findById(testUtilisateur.getId());
        // then
        assertEquals(testUtilisateur, retreivedUtilisateur);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        // given
        // when
        utilisateurService.delete(randomUtilisateur);
        // then
        assertNull(utilisateurService.findById(randomUtilisateur.getId()));
    }

    @Test
    void findById() {
        // given
        // when
        Utilisateur utilisateur = utilisateurService.findById(randomUtilisateur.getId());
        // then
        assertEquals(randomUtilisateur, utilisateur);
    }

    @Test
    void findAll() {
        //given
        //when
        int size = utilisateurService.findAll().size();
        //then
        assertTrue(size > 0);
    }

    @Test
    void findByEmail() {
        // given
        // when
        Utilisateur utilisateur = utilisateurService.findByEmail(randomUtilisateur.getEmail());
        // then
        assertEquals(randomUtilisateur, utilisateur);
    }
}