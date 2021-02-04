package ua.com.cinema.dao;

import ua.com.cinema.model.ShoppingCart;
import ua.com.cinema.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
