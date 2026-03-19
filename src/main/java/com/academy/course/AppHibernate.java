
package com.academy.course;

import com.academy.course.dto.Car;
import com.academy.course.hierarchy.Address;
import com.academy.course.hierarchy.Employee1;
import com.academy.course.hierarchy.Person1;
import com.academy.course.hierarchy.Student;
import org.hibernate.Session;


import javax.persistence.EntityManager;

public class AppHibernate {
    public static void main(String[] args) {
//        Car car = Car.builder()
//                .name("Corolla")
//                .type("Toyota")
//                .build();
        EntityManager em = HibernateUtil.getEntityManager();
//        em.getTransaction().begin();
//        em.persist(car);
//        car.setType("Toyota new");
//        em.merge(car);
//        em.getTransaction().commit();

        Student student = Student.builder()
                .mark(9.5)
                .faculty("Literature")
                .build();

        Employee1 employee1 = Employee1.builder()
                .salary(200.10)
                .company("corporation")
                .build();

        Person1 person1 = Person1.builder()
                .name("Sam")
                .surname("samuel")
                .build();
//
//
//
//        Car carNew = Car.builder()
//                .name("Corolla2")
//                .type("Toyota2")
//                .build();
//        Session session = em.unwrap(Session.class);
//        session.getTransaction().begin();
//        session.save(carNew);
//        Car carDb = session.get(Car.class, carNew.getId());
//        Car carDbLoad = session.load(Car.class,carNew.getId());
//        System.out.println(carDb);
//        carDb.setType("new");
//        session.refresh(carDb);
//        session.saveOrUpdate(carNew);
//        session.delete(carNew);
//        session.getTransaction().commit();
        em.getTransaction().begin();
        em.persist(student);
        em.persist(employee1);
        em.persist(person1);
        em.getTransaction().commit();



        em.close();
        HibernateUtil.close();
    }
}
