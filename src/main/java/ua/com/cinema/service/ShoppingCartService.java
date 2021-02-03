package ua.com.cinema.service;

import ua.com.cinema.model.MovieSession;
import ua.com.cinema.model.ShoppingCart;
import ua.com.cinema.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
