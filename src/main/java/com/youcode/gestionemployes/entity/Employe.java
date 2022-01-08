package com.youcode.gestionemployes.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "employes")
public class Employe extends Utilisateur implements Serializable {
    private String matricule;
    private Float salaire;

}
