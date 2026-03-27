package com.academy.course.hibernateDao;

import com.academy.course.hibernateDao.dao.CarDAO;
import com.academy.course.hibernateDao.dao.CarDaoImpl;
import com.academy.course.hibernateDao.model.Car;
import com.academy.course.hibernateDao.session.HibernateSession;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        CarDAO dao = new CarDaoImpl(Car.class);
     List<Car> list = dao.findByType("updateType");
     for(Car car : list){
         System.out.println(car);
     }
        HibernateSession.close();
    }
}
