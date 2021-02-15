package ua.com.cinema.dao;

import java.util.Optional;
import ua.com.cinema.model.Ticket;

public interface TicketDao {
    Ticket add(Ticket ticket);

    Optional<Ticket> getById(Long id);
}
