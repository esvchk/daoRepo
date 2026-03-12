package com.academy.course.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {

    public static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    public static final Session getSession(){
        return SESSION_FACTORY.openSession();
    }

    public static void close(){
        SESSION_FACTORY.close();
    }
}
