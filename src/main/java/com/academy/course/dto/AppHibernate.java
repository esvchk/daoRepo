
package com.academy.course.dto;

import com.academy.course.HibernateUtil;
import org.hibernate.Session;


import javax.persistence.EntityManager;

public class AppHibernate {
    public static void main(String[] args) {
        Car car = Car.builder()
                .name("Corolla")
                .type("Toyota")
                .build();
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(car);
        car.setType("Toyota new");
        em.merge(car);
        em.getTransaction().commit();



        Car carNew = Car.builder()
                .name("Corolla2")
                .type("Toyota2")
                .build();
        Session session = em.unwrap(Session.class);
        session.getTransaction().begin();
        session.save(carNew);
        Car carDb = session.get(Car.class, carNew.getId());
        Car carDbLoad = session.load(Car.class,carNew.getId());
        System.out.println(carDb);
        carDb.setType("new");
        session.refresh(carDb);
        session.saveOrUpdate(carNew);
        session.delete(carNew);
        session.getTransaction().commit();


        em.close();
        HibernateUtil.close();
    }
}
