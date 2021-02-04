package ua.com.cinema.dao;

import java.util.List;
import ua.com.cinema.model.Order;
import ua.com.cinema.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
