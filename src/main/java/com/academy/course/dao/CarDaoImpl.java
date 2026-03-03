package com.academy.course.dao;

import com.academy.course.connection.Connector;
import com.academy.course.dto.Car;

import java.io.Serializable;
import java.sql.*;
import java.time.LocalDateTime;

public class CarDaoImpl implements CarDao {


    @Override
    public Car save(Car car) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("INSERT INTO car " +
                    "(name,type) " +
                    "VALUES('" + car.getName() + "','" + car.getType() + "')",
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            long primaryKey = rs.getLong(1);
            car.setId(primaryKey);
        }
        return car;
    }

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
