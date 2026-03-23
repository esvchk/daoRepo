package com.academy.course.hibernateDao;

import com.academy.course.hibernateDao.dao.DAO;
import com.academy.course.hibernateDao.dao.DAOImpl;
import com.academy.course.hibernateDao.model.Car;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DAO<Car> dao = new DAOImpl<>(Car.class);
        Car car = Car.builder()
                .type("Nissan")
                .name("Skyline")
                .build();
        dao.save(car);
    }
}
