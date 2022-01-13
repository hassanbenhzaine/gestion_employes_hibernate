package com.youcode.gestionemployes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "utilisateurs")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Utilisateur.findAll", query = "SELECT a FROM utilisateurs a")
@NamedQuery(name = "Utilisateur.findByEmail",
        query = "SELECT a FROM utilisateurs a WHERE a.email = :email")
public class Utilisateur implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(unique = true)
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String password;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column
    private String phone;
    @Column(columnDefinition = "boolean default false")
    private Boolean status;

    @OneToMany
    private List<Adresse> adresses;
}
