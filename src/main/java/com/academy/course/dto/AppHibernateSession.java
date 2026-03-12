package com.academy.course.dto;

import com.academy.course.HibernateUtil;
import com.academy.course.dao.HibernateSession;
import org.hibernate.Session;

public class AppHibernateSession {
    public static void main(String[] args) {
        Car carNew = Car.builder()
                .name("Corolla3")
                .type("Toyota3")
                .build();
        Session session = HibernateSession.getSession();
        session.getTransaction().begin();
        session.save(carNew);
        Car carDb = session.get(Car.class,carNew.getId());
        session.getTransaction().commit();

        session.close();
        HibernateSession.close();
    }
}
