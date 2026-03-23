package hibernateDao.dao;

import hibernateDao.model.Car;

import java.util.List;

public interface CarDAO extends DAO<Car> {
    List<Car> findByType(String type);

}
