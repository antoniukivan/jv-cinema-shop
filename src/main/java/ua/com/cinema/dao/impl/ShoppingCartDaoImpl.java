package ua.com.cinema.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.com.cinema.dao.ShoppingCartDao;
import ua.com.cinema.exception.DataProcessingException;
import ua.com.cinema.lib.Dao;
import ua.com.cinema.model.ShoppingCart;
import ua.com.cinema.model.User;
import ua.com.cinema.util.HibernateUtil;

@Dao
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(shoppingCart);
            transaction.commit();
            return shoppingCart;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert shoppingCart entity: "
                    + shoppingCart, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<ShoppingCart> getShoppingCartByUserQuery
                    = session.createQuery("from ShoppingCart sc left join fetch sc.tickets t "
                    + "left join fetch t.movieSession m left join fetch m.movie "
                    + "left join fetch m.cinemaHall where sc.user.email = :email "
                    + "and sc.user.password = :password", ShoppingCart.class);
            getShoppingCartByUserQuery.setParameter("email", user.getEmail());
            getShoppingCartByUserQuery.setParameter("password", user.getPassword());
            return getShoppingCartByUserQuery.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get shopping cart by user: "
                    + user, e);
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(shoppingCart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Couldn't update " + shoppingCart, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
