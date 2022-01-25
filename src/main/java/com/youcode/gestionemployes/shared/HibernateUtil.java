package com.youcode.gestionemployes.shared;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sf;

    public static SessionFactory getSessionFactory() {
        if (sf == null) sf = new Configuration().configure().buildSessionFactory();
        return sf;
    }

    public static void close() {
        if (sf != null) sf.close();
    }
}
