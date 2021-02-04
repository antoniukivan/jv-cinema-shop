package ua.com.cinema.dao;

import java.util.List;
import ua.com.cinema.model.Order;
import ua.com.cinema.model.ShoppingCart;
import ua.com.cinema.model.User;

public interface OrderDao {
    Order add(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
