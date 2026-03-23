package com.academy.course.hibernateDao.dao;


import com.academy.course.hibernateDao.model.Car;
import com.academy.course.hibernateDao.session.HibernateSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.io.Serializable;
import java.util.List;

public class CarDaoImpl implements CarDAO {

    private static final Logger log = LogManager.getLogger(CarDaoImpl.class);

    @Override
    public List<Car> findByType(String type) {
        try (Session session = HibernateSession.getSession()) {
             Query<Car> query = session.createQuery
                    ("SELECT c from Car c WHERE c.type = :type", Car.class);
             query.setParameter("type",type);
             log.info("Find by type " + type + "cars" + query );
             return query.getResultList();
        } catch (HibernateException e) {
            log.error("Cannot find by type " + type);
        }
        return null;
    }

    @Override
    public Car save(Car entity) {
        try (Session session = HibernateSession.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(entity);
            transaction.commit();
            log.info("Saving car " + entity);
        }catch (HibernateException e) {
            log.error("Cannot save car " + entity);
        }
        return entity;
    }

    @Override
    public Car get(Serializable id) {
        Car car;
        try (Session session = HibernateSession.getSession()) {
            car = session.get(Car.class, id);
            log.info("Receive by id " + id + " car " + car);
            return car;
        } catch (HibernateException e) {
            log.error("Cannot receive by id " + id);
        }
        return null;
    }

    @Override
    public void update(Car entity) {
        try (Session session = HibernateSession.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(entity);
            transaction.commit();
            log.info("Update car " + entity);
        } catch (HibernateException e) {
            log.error("Cannot update car " + entity);
        }

    }

    @Override
    public Integer delete(Serializable id) {
        Car car;
        try (Session session = HibernateSession.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            car = session.load(Car.class, id);
            session.delete(car);
            transaction.commit();
            log.info("Delete by id " + id + " car " + car);
            return car.getId();
        } catch (HibernateException e) {
            log.error("Cannot delete by id " + id);
        }
        return null;
    }
}
