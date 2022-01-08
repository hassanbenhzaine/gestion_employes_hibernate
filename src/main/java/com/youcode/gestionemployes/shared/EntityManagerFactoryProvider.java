package com.youcode.gestionemployes.shared;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryProvider {
    private static EntityManagerFactoryProvider emp;
    private final EntityManagerFactory emf;

    public EntityManagerFactoryProvider() {
        emf = Persistence
                .createEntityManagerFactory("GestionEmployesPU");
    }

    public static EntityManagerFactoryProvider getInstance() {
        if (emp == null) {
            emp = new EntityManagerFactoryProvider();
        }
        return emp;
    }

    public EntityManagerFactory get() {
        return emf;
    }

    public void close() {
        emf.close();
    }
}
