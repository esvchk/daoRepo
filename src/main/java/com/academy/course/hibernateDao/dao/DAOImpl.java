package com.academy.course.hibernateDao.dao;

import com.academy.course.hibernateDao.session.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.io.Serializable;


public class DAOImpl<T> implements DAO<T> {
    private Class<T> entityClass;

    public DAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T save(T entity)  {
        try(Session session1 = HibernateSession.getSession()) {
            Transaction transaction = session1.getTransaction();
            transaction.begin();
            session1.persist(entity);
            transaction.commit();
        }
        return entity;
    }

    @Override
    public T get(Serializable id)  {
        T t;
        try (Session session1 = HibernateSession.getSession()){
            t = session1.get(entityClass,id);
        }
        return t;
    }

    @Override
    public void update(T entity)  {
        try (Session session1 = HibernateSession.getSession()){
            Transaction transaction = session1.getTransaction();
            transaction.begin();
            session1.saveOrUpdate(entity);
            transaction.commit();
        }
    }

    @Override
    public Integer delete(Serializable id) {
        T t ;
        try (Session session1 = HibernateSession.getSession()){
            Transaction transaction = session1.getTransaction();
            transaction.begin();
            t = session1.load(entityClass,id);
            session1.delete(t);
            transaction.commit();
        }
        return (Integer) id;
    }
}
