package ua.com.cinema.service;

import java.util.Optional;
import ua.com.cinema.model.Ticket;

public interface TicketService {
    Ticket add(Ticket ticket);

    Optional<Ticket> getById(Long id);
}
