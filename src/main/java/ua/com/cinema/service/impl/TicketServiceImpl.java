package ua.com.cinema.service.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;
import ua.com.cinema.dao.TicketDao;
import ua.com.cinema.model.Ticket;
import ua.com.cinema.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Ticket add(Ticket ticket) {
        return ticketDao.add(ticket);
    }

    @Override
    public Optional<Ticket> getById(Long id) {
        return ticketDao.getById(id);
    }

}
