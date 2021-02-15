package ua.com.cinema.dao;

import java.util.List;
import ua.com.cinema.model.Ticket;
import ua.com.cinema.model.User;

public interface TicketDao {
    Ticket add(Ticket ticket);

    List<Ticket> getAllByUser(User user);
}
