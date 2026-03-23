package com.academy.course.hibernateDao.dao;


import com.academy.course.hibernateDao.model.User;
import com.academy.course.hibernateDao.session.HibernateSession;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class UserDaoImpl implements UserDAO {

    private static final Logger log = LogManager.getLogger(UserDaoImpl.class);

    @Override
    public List<User> findByAddress(String address) {
        try (Session session = HibernateSession.getSession()) {
            Query<User> query = session.createQuery
                    ("SELECT u FROM people u WHERE u.address = :address", User.class);
            query.setParameter("address", address);
            log.info("Reading users by " + address);
            return query.getResultList();
        } catch (HibernateException e) {
            log.error("Cannot find users by address");
        }
        return null;
    }


    @Override
    public User save(User entity) {
        try (Session session = HibernateSession.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(entity);
            log.info("Saving user " + entity);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Cannot save entity " + entity);
        }
        return entity;
    }

    @Override
    public User get(Serializable id) {
        User user;
        try (Session session = HibernateSession.getSession()) {
            user = session.get(User.class, id);
            log.info("Receive by id " + id + " user " + user);
            return user;
        } catch (HibernateException e) {
            log.error("Cannot find by " + id);
        }
        return null;
    }

    @Override
    public void update(User entity) {
        try (Session session = HibernateSession.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(entity);
            transaction.commit();
            log.info("Update user " + entity);
        } catch (HibernateException e) {
            log.error("Cannot update entity " + entity);
        }
    }

    @Override
    public Integer delete(Serializable id) {
        User user;
        try (Session session = HibernateSession.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            user = session.load(User.class, id);
            session.delete(user);
            transaction.commit();
            log.info("Delete user " + user + " by id " + id);
        }
        return user.getId();
    }
}
