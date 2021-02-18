package ua.com.cinema.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.cinema.dao.AbstractDao;
import ua.com.cinema.dao.ShoppingCartDao;
import ua.com.cinema.exception.DataProcessingException;
import ua.com.cinema.model.ShoppingCart;
import ua.com.cinema.model.User;

@Repository
public class ShoppingCartDaoImpl extends AbstractDao<ShoppingCart, Long>
        implements ShoppingCartDao {
    @Autowired
    public ShoppingCartDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, ShoppingCart.class);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Query<ShoppingCart> getShoppingCartByUserQuery
                    = session.createQuery("from ShoppingCart sc left join fetch sc.tickets "
                    + "where sc.user = :user", ShoppingCart.class);
            getShoppingCartByUserQuery.setParameter("user", user);
            return getShoppingCartByUserQuery.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get shopping cart by user: "
                    + user, e);
        }
    }
}
