package ua.com.cinema.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.com.cinema.dao.TicketDao;
import ua.com.cinema.exception.DataProcessingException;
import ua.com.cinema.model.Ticket;
import ua.com.cinema.util.HibernateUtil;

public class TicketDaoImpl implements TicketDao {
    @Override
    public Ticket add(Ticket ticket) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert ticket entity: "
                    + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
