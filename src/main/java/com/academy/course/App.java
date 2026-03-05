package com.academy.course;

import com.academy.course.dao.CarDao;
import com.academy.course.dao.CarDaoImpl;
import com.academy.course.dto.Car;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        CarDao carDao = new CarDaoImpl();
        Car car = Car.builder()
                .name("vito")
                .type("mercedes")
                .build();
        Car save = carDao.save(car);
//        System.out.println(save.getId());
        Car car1 = carDao.get(save.getId());
        System.out.println(car1);
    }
}
