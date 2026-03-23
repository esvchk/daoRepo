package hibernateDao.dao;

import hibernateDao.model.User;

import java.util.List;

public interface UserDAO extends DAO<User> {
    List<User> findByAddress(String address);
}
