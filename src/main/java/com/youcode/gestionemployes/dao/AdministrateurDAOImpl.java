package com.youcode.gestionemployes.dao;

import com.youcode.gestionemployes.entity.Administrateur;
import com.youcode.gestionemployes.shared.EntityManagerFactoryProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class AdministrateurDAOImpl implements GenericDAO<Administrateur, Integer> {
    private final EntityManager entityManager;
    private final String tableName = "administrateurs";

    public AdministrateurDAOImpl() {
        EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().get();
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public void create(Administrateur administrateur) {
        entityManager.getTransaction().begin();
        entityManager.persist(administrateur);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Optional<Administrateur> get(Integer id) {
        entityManager.getTransaction().begin();
        Optional<Administrateur> administrateur = Optional
                .of(entityManager.find(Administrateur.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
        return administrateur;
    }

    @Override
    public Collection<Administrateur> getAll() {
        entityManager.getTransaction().begin();
        List<Administrateur> administrateurList = entityManager
                .createQuery("SELECT a FROM " + tableName + " a", Administrateur.class)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return administrateurList;
    }

    @Override
    public Administrateur update(Administrateur administrateur) {
        entityManager.getTransaction().begin();
        Administrateur updatedAdministrateur = entityManager.merge(administrateur);
        entityManager.getTransaction().commit();
        entityManager.close();
        return updatedAdministrateur;
    }

    @Override
    public void delete(Administrateur administrateur) {
        entityManager.getTransaction().begin();
        entityManager.remove(administrateur);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
