package com.youcode.gestionemployes.shared;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryProvider {
    private static EntityManagerFactoryProvider instance;
    private final EntityManagerFactory emf;

    public EntityManagerFactoryProvider() {
        emf = Persistence
                .createEntityManagerFactory("GestionEmployesPU");
    }

    public static EntityManagerFactoryProvider getInstance() {
        if (instance == null) {
            instance = new EntityManagerFactoryProvider();
        }
        return instance;
    }

    public EntityManagerFactory get() {
        return emf;
    }

    public void close() {
        emf.close();
    }
}
