package com.academy.course.hibernateDao.dao;

import com.academy.course.hibernateDao.model.User;

import java.util.List;

public interface UserDAO extends DAO<User> {
    List<User> findByAddress(String address);
}
