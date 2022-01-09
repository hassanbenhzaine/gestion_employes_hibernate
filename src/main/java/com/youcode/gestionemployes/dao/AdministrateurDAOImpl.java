package com.youcode.gestionemployes.dao;

import com.youcode.gestionemployes.entity.Administrateur;
import com.youcode.gestionemployes.shared.EntityManagerFactoryProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class AdministrateurDAOImpl implements GenericDAO<Administrateur, Integer> {
    private final EntityManager em;

    public AdministrateurDAOImpl() {
        EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().get();
        this.em = emf.createEntityManager();
    }

    @Override
    public Administrateur create(Administrateur administrateur) {
        em.getTransaction().begin();
        em.persist(administrateur);
        em.getTransaction().commit();
        em.close();
        return administrateur;
    }

    @Override
    public Optional<Administrateur> get(Integer id) {
        Optional<Administrateur> administrateur = Optional
                .of(em.find(Administrateur.class, id));
        em.close();
        return administrateur;
    }

    @Override
    public Collection<Administrateur> getAll() {
        List<Administrateur> administrateurList = em
                .createQuery("Administrateur.findAll", Administrateur.class)
                .getResultList();
        em.close();
        return administrateurList;
    }

    @Override
    public Administrateur update(Administrateur administrateur) {
        em.getTransaction().begin();
        Administrateur updatedAdministrateur = em.merge(administrateur);
        em.getTransaction().commit();
        em.close();
        return updatedAdministrateur;
    }

    @Override
    public void delete(Administrateur administrateur) {
        em.getTransaction().begin();
        em.remove(administrateur);
        em.getTransaction().commit();
        em.close();
    }


}
