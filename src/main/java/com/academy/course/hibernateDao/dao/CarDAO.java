package com.academy.course.hibernateDao.dao;

import com.academy.course.hibernateDao.model.Car;

import java.util.List;

public interface CarDAO extends DAO<Car> {
    List<Car> findByType(String type);

}
