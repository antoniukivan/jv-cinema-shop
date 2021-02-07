package ua.com.cinema.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.com.cinema.dao.OrderDao;
import ua.com.cinema.exception.DataProcessingException;
import ua.com.cinema.lib.Dao;
import ua.com.cinema.model.Order;
import ua.com.cinema.model.User;
import ua.com.cinema.util.HibernateUtil;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order add(Order order) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert order entity: "
                    + order, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("select distinct o from Order o join fetch o.tickets "
                    + "where o.user = :user", Order.class)
                    .setParameter("user", user)
                    .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get orders history by user: " + user, e);
        }
    }
}
