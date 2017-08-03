package com.project_restaurant.dao.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by xuero on 2017/7/27.
 */
public class HibernateUtils {
    static private ThreadLocal<SessionFactory> sessionFactoryThreadLocal = new ThreadLocal<SessionFactory>();

    static public Session getSession() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        sessionFactoryThreadLocal.set(sessionFactory);
        return sessionFactory.openSession();
    }

    static public void close(Session session) {
        session.close();
        SessionFactory sessionFactory = sessionFactoryThreadLocal.get();
        sessionFactory.close();
        sessionFactoryThreadLocal.remove();
    }
}
