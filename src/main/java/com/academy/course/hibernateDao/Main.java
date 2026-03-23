package com.academy.course.hibernateDao;

import com.academy.course.hibernateDao.dao.CarDAO;
import com.academy.course.hibernateDao.dao.CarDaoImpl;
import com.academy.course.hibernateDao.model.Car;
import com.academy.course.hibernateDao.session.HibernateSession;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CarDAO dao = new CarDaoImpl(Car.class);
        Car car = Car.builder()
                .type("Nissan")
                .name("Skyline")
                .build();
        dao.save(car);

        HibernateSession.close();
    }
}
