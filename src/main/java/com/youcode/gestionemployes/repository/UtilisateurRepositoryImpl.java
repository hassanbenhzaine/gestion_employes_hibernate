package com.youcode.gestionemployes.repository;

import com.youcode.gestionemployes.entity.Utilisateur;
import com.youcode.gestionemployes.shared.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.Optional;

public class UtilisateurRepositoryImpl implements IUtilisateurRepository {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public void save(Utilisateur utilisateur) {
        Transaction tx = null;
        try (Session session = sf.openSession()) {
            tx = session.beginTransaction();
            session.save(utilisateur);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Utilisateur> findById(Integer id) {
        try (Session session = sf.openSession()) {
            return Optional.ofNullable(session.get(Utilisateur.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Collection<Utilisateur> findAll() {
        try (Session session = sf.openSession()) {
            return session.createNamedQuery("Utilisateur.findAll", Utilisateur.class)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Utilisateur update(Utilisateur utilisateur) {
        Transaction tx = null;
        try (Session session = sf.openSession()) {
            tx = session.beginTransaction();
            session.update(utilisateur);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
        return utilisateur;
    }

    @Override
    public void delete(Utilisateur utilisateur) {
        Transaction tx = null;
        try (Session session = sf.openSession()) {
            tx = session.beginTransaction();
            session.delete(utilisateur);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }

    @Override
    public Optional<Utilisateur> findByEmail(String email) {
        try (Session session = sf.openSession()) {
            return session.createNamedQuery("Utilisateur.findByEmail", Utilisateur.class)
                    .setParameter("email", email)
                    .uniqueResultOptional();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
