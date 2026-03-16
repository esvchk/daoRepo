package com.academy.course.dao;

import com.academy.course.ClassAnn;

import java.io.Serializable;
import java.sql.SQLException;

public interface DAO<T> {

    default T save(T t) throws SQLException {
        Class<?> tclass = t.getClass();
        ClassAnn classAnn = tclass.getAnnotation(ClassAnn.class);
        System.out.println(classAnn.value());
        return t;
    }

    T get(Serializable id) throws SQLException;

    void update(T t) throws SQLException;

    int delete(Serializable id) throws SQLException;
}
