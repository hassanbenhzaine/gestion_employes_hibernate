package com.youcode.gestionemployes.repository;

import com.youcode.gestionemployes.entity.Employe;
import com.youcode.gestionemployes.shared.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.Optional;

public class EmployeRepositoryImpl implements IEmployeRepository {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public void save(Employe utilisateur) {
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
    public Optional<Employe> findById(Integer id) {
        try (Session session = sf.openSession()) {
            return Optional.ofNullable(session.get(Employe.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Collection<Employe> findAll() {
        try (Session session = sf.openSession()) {
            return session.createNamedQuery("Employe.findAll", Employe.class)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employe update(Employe utilisateur) {
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
    public void delete(Employe utilisateur) {
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
