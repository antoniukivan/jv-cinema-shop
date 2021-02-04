package ua.com.cinema.service.impl;

import java.util.List;
import ua.com.cinema.dao.OrderDao;
import ua.com.cinema.lib.Inject;
import ua.com.cinema.lib.Service;
import ua.com.cinema.model.Order;
import ua.com.cinema.model.ShoppingCart;
import ua.com.cinema.model.User;
import ua.com.cinema.service.OrderService;
import ua.com.cinema.service.ShoppingCartService;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setUser(shoppingCart.getUser());
        order.setTickets(shoppingCart.getTickets());
        shoppingCartService.clear(shoppingCart);
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
