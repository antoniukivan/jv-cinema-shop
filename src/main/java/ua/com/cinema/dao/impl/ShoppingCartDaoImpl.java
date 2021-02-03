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
            session.persist(shoppingCart);
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
                    = session.createQuery("from ShoppingCart sc where sc.user.email = :email "
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<ShoppingCart> updateShoppingCart
                    = session.createQuery("update ShoppingCart sc set sc.tickets = :tickets " +
                    "where sc.user.email = :email ", ShoppingCart.class);
            updateShoppingCart.setParameter("email", shoppingCart.getUser().getEmail());
            updateShoppingCart.setParameter("tickets", shoppingCart.getTickets());
            updateShoppingCart.executeUpdate();
        } catch (Exception e) {
            throw new DataProcessingException("Can't update shopping cart: "
                    + shoppingCart, e);
        }
    }
}
