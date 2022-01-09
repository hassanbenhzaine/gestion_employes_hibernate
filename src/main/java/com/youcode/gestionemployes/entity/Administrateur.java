package com.youcode.gestionemployes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "administrateurs")
@NamedQuery(name = "Administrateur.findAll", query = " SELECT a FROM administrateurs a")
public class Administrateur extends Utilisateur implements Serializable {
    private String xccc;

    @Override
    public String toString() {
        return "Administrateur{" +
                "xccc='" + xccc + '\'' +
                "} " + super.toString();
    }
}
