package hibernateDao;

import hibernateDao.dao.DAO;
import hibernateDao.dao.DAOImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DAO<Car> dao = new DAOImpl<>(Car.class);
        Car car = dao.save(new Car("Skyline","Nissan"));
    }
}
