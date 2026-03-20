package com.academy.course.dao;

import com.academy.course.dto.Car;

import java.io.Serializable;
import java.sql.SQLException;

public class DAOClass implements DAO<Car>{

    @Override
    public Car get(Serializable id) throws SQLException {
        return null;
    }

    @Override
    public void update(Car car) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }
}
