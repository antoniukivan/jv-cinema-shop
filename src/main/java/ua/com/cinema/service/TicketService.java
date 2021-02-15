package ua.com.cinema.service;

import java.util.List;
import ua.com.cinema.model.Ticket;
import ua.com.cinema.model.User;

public interface TicketService {
    Ticket add(Ticket ticket);

    List<Ticket> getAllByUser(User user);
}
