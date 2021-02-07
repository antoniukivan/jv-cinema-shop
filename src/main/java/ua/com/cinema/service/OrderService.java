package ua.com.cinema.service;

import java.util.List;
import ua.com.cinema.model.Order;
import ua.com.cinema.model.ShoppingCart;
import ua.com.cinema.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
