package com.youcode.gestionemployes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "utilisateurs")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Utilisateur.findAll", query = "FROM utilisateurs"),
        @NamedQuery(name = "Utilisateur.findByEmail",
                query = "FROM utilisateurs WHERE email = :email")
})
public class Utilisateur {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilisateurs_seq")
    @SequenceGenerator(name = "utilisateurs_seq", sequenceName = "utilisateurs_seq",
            allocationSize = 1)
    @Id
    @Column(updatable = false)
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
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 1)
    private GenderType gender;
    private Short age;

//    @ElementCollection
//    private List<Adresse> adresses = new HashSet<>();

}
