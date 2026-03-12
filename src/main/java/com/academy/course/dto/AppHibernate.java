package com.academy.course.dto;

import com.academy.course.HibernateUtil;
import com.sun.net.httpserver.BasicAuthenticator;
import org.hibernate.Session;


import javax.persistence.EntityManager;

public class AppHibernate {
    public static void main(String[] args) {
        Car car = Car.builder()
                .name("Corolla")
                .type("Toyota")
                .build();
        EntityManager em = HibernateUtil.getEntityManager();


        Car carNew = Car.builder()
                .name("Corolla2")
                .type("Toyota2")
                .build();
        Session session = em.unwrap(Session.class);
        session.getTransaction().begin();
        session.save(carNew);
        Car carDb = session.get(Car.class, carNew.getId());
        System.out.println(carDb);
        session.getTransaction().commit();

//        em.getTransaction().begin();
//        em.persist(car);
//        em.getTransaction().commit();
//        em.close();

        HibernateUtil.close();
    }
}
