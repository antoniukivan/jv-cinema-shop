package ua.com.cinema.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.cinema.dao.AbstractDao;
import ua.com.cinema.dao.OrderDao;
import ua.com.cinema.exception.DataProcessingException;
import ua.com.cinema.model.Order;
import ua.com.cinema.model.User;

@Repository
public class OrderDaoImpl extends AbstractDao<Order, Long> implements OrderDao {
    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Order.class);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select distinct o from Order o join fetch o.tickets "
                    + "where o.user = :user", Order.class)
                    .setParameter("user", user)
                    .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get orders history by user: " + user, e);
        }
    }
}
