package com.youcode.gestionemployes;

import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;

@WebServlet
public class Main {
    public static void main(String[] args) {
        Persistence.generateSchema("GestionEmployesPU", null);

    }
}
