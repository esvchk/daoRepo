package com.academy.course.dto;

import com.academy.course.HibernateUtil;

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
        em.getTransaction().commit();
        em.close();
        HibernateUtil.close();
    }
}
