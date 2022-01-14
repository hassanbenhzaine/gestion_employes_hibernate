package com.youcode.gestionemployes.metier;

import com.youcode.gestionemployes.entity.Employe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Random.class)
class EmployeServiceTest {
    private EmployeService employeService;
    private Employe employe;

    @BeforeEach
    void setUp() {
        employeService = new EmployeService();
        employe = Employe.builder()
                .email("example".concat(
                        String.valueOf(new Random().nextInt(0, 9999))
                ) + "@mail.com")
                .password("passwd".concat(
                        String.valueOf(new Random().nextInt(100, 999))
                ))
                .firstName("firstName")
                .lastName("lastName")
                .dateOfBirth(LocalDate.of(
                        new Random().nextInt(1950, 2021),
                        new Random().nextInt(1, 12),
                        new Random().nextInt(1, 28)
                ))
                .phone("06".concat(
                        String.valueOf(new Random().nextInt(0, 99999999))
                ))
                .status(new Random().nextBoolean())
                .matricule("AD" + new Random().nextInt(0, 999999))
                .salaire(new Random().nextDouble(3000, 15000))
                .build();
    }

    @Test
    void save() {
        // given
        // when
        Employe savedEmploye = employeService.save(employe);
        // then
        assertEquals(savedEmploye, employeService.findById(savedEmploye.getId()));
    }

    @Test
    void update() {
        // given
        Employe foundEmploye = employeService.findAll().stream()
                .findAny().orElse(null);
        if (foundEmploye != null) {
            foundEmploye.setLastName("newLastName");
            foundEmploye.setMatricule("AB" + new Random().nextInt(0, 999999));
        }
        // when
        Employe returnedEmploye = employeService.update(foundEmploye);
        // then
        assertEquals(foundEmploye, returnedEmploye);
    }

    @Test
    void delete() {
        // given
        Employe savedEmploye = employeService.save(employe);
        // when
        employeService.delete(savedEmploye);
        // then
        assertNull(employeService.findById(savedEmploye.getId()));
    }

    @Test
    void findById() {
        // given
        Employe savedEmploye = employeService.save(employe);
        // when
        Employe foundEmploye = employeService.findById(savedEmploye.getId());
        // then
        assertEquals(savedEmploye.getId(), foundEmploye.getId());
    }

    @Test
    void findAll() {
        //given
        employeService.save(employe);
        //when
        Collection<? extends Employe> foundEmployeList = employeService.findAll();
        //then
        assertTrue(foundEmployeList.size() > 0);
    }
}