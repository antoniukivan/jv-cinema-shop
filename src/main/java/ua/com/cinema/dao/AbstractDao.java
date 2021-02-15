package ua.com.cinema.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.cinema.exception.DataProcessingException;

public abstract class AbstractDao<T, ID extends Serializable> {
    private final SessionFactory sessionFactory;
    private final Class<T> type;

    protected AbstractDao(SessionFactory sessionFactory, Class<T> type) {
        this.sessionFactory = sessionFactory;
        this.type = type;
    }

    public T add(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
            return entity;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't create: " + entity, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<T> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from " + type.getSimpleName(), type).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all: " + type.getSimpleName(), e);
        }
    }

    public Optional<T> getById(ID id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(type, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get: " + type.getSimpleName()
                    + " by id " + id, e);
        }
    }

    public void delete(ID id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(session.load(type, id));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete by id: " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void update(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update: " + entity, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
