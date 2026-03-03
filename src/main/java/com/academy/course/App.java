package com.academy.course;

import com.academy.course.dao.CarDao;
import com.academy.course.dao.CarDaoImpl;
import com.academy.course.dto.Car;

import java.sql.SQLException;

public class App
{
    public static void main( String[] args ) throws SQLException {
        CarDao carDao = new CarDaoImpl();
        Car car = new Car();
        car.setName("mercedes");
        car.setType("vito");
        System.out.println(carDao.save(car).getId());
    }
}
