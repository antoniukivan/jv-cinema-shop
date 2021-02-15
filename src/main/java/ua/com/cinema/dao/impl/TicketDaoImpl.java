package ua.com.cinema.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.cinema.dao.AbstractDao;
import ua.com.cinema.dao.TicketDao;
import ua.com.cinema.model.Ticket;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket, Long> implements TicketDao {
    @Autowired
    public TicketDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Ticket.class);
    }
}
