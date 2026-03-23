package com.academy.course.hibernateDao;

import com.academy.course.hibernateDao.dao.CarDAO;
import com.academy.course.hibernateDao.dao.CarDaoImpl;
import com.academy.course.hibernateDao.dao.DAO;
import com.academy.course.hibernateDao.dao.DAOImpl;
import com.academy.course.hibernateDao.model.Car;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DAO<Car> dao = new CarDaoImpl();
        Car car = Car.builder()
                .type("Nissan")
                .name("Skyline")
                .build();
        dao.save(car);
    }
}
