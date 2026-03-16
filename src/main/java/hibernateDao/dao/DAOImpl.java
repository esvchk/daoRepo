package hibernateDao.dao;

import hibernateDao.session.HibernateSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.io.Serializable;


public class DAOImpl<T> implements DAO<T> {
    private final Session session = HibernateSession.getSession();
    private final Transaction transaction = session.getTransaction();
    Class<T> entityClass;

    public DAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T save(T entity)  {
        try {
            transaction.begin();
            session.save(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            HibernateSession.close();
        }
        return entity;
    }

    @Override
    public T get(Serializable id)  {
        T t = null;
        try {
            transaction.begin();
            t = session.get(entityClass,id);
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
        } finally {
            HibernateSession.close();
        }
        return t;
    }

    @Override
    public void update(T entity)  {
        try {
            transaction.begin();
            session.saveOrUpdate(entity);
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
        } finally {
            HibernateSession.close();
        }
    }

    @Override
    public Integer delete(Serializable id) {
        T t ;
        try {
            transaction.begin();
            t = session.load(entityClass,id);
            session.delete(t);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            HibernateSession.close();
        }
        return (Integer) id;
    }

    @Override
    public String toString() {
        return "DAOImpl{" +
                "session=" + session +
                '}';
    }
}
