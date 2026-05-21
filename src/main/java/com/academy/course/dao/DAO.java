package com.academy.course.dao;

import java.io.Serializable;
import java.sql.SQLException;

public interface DAO<T> {

    default T save(T t) throws SQLException {
        return null;
    }

    T get(Serializable id) throws SQLException;

    void update(T t) throws SQLException;

    int delete(Serializable id) throws SQLException;
}
