package com.youcode.gestionemployes.repository;

import com.youcode.gestionemployes.entity.Administrateur;
import com.youcode.gestionemployes.shared.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.Optional;

public class AdministrateurRepositoryImpl implements IAdministrateurRepository {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public void save(Administrateur utilisateur) {
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
    public Optional<Administrateur> findById(Integer id) {
        try (Session session = sf.openSession()) {
            return Optional.ofNullable(session.get(Administrateur.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Collection<Administrateur> findAll() {
        try (Session session = sf.openSession()) {
            return session.createNamedQuery("Administrateur.findAll", Administrateur.class)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Administrateur update(Administrateur utilisateur) {
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
    public void delete(Administrateur utilisateur) {
        Transaction tx = null;
        try (Session session = sf.openSession()) {
            tx = session.beginTransaction();
            session.delete(utilisateur);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }
}
