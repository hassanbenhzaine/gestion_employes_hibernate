package com.youcode.gestionemployes;

import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Persistence.generateSchema("GestionEmployesPU", null);
    }
}
