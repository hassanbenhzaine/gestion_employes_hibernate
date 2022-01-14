package com.youcode.gestionemployes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@PrimaryKeyJoinColumn(name = "employe_id")
@NamedQuery(name = "Employe.findAll", query = " SELECT a FROM employes a")
public class Employe extends Utilisateur implements Serializable {
    @Column(unique = true)
    private String matricule;
    private Double salaire;

    @Override
    public String toString() {
        return "Employe{" +
                "matricule='" + matricule + '\'' +
                ", salaire=" + salaire +
                "} " + super.toString();
    }
}
