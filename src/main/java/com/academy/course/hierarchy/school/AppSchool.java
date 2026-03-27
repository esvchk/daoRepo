package com.academy.course.hierarchy.school;

import com.academy.course.HibernateUtil;

import javax.persistence.EntityManager;

public class AppSchool {
    public static void main(String[] args) {
        EntityManager em = HibernateUtil.getEntityManager();
        School school = School.builder()
                .type("Language")
                .name("Collin")
                .build();

        University university = University.builder()
                .grade("high")
                .build();
        em.getTransaction().begin();
        em.persist(school);
        em.persist(university);
        em.getTransaction().commit();

    }
}
