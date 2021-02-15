package ua.com.cinema.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.cinema.dao.AbstractDao;
import ua.com.cinema.dao.TicketDao;
import ua.com.cinema.exception.DataProcessingException;
import ua.com.cinema.model.Ticket;
import ua.com.cinema.model.User;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket, Long> implements TicketDao {
    @Autowired
    public TicketDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Ticket.class);
    }

    @Override
    public List<Ticket> getAllByUser(User user) {
        try (Session session = getSessionFactory().openSession()) {
            return session.createQuery("from Ticket t where t.user = :user", Ticket.class)
                    .setParameter("user", user)
                    .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get tickets by user: " + user, e);
        }
    }
}
