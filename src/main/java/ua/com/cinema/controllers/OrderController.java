package ua.com.cinema.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cinema.model.Order;
import ua.com.cinema.model.User;
import ua.com.cinema.service.OrderService;
import ua.com.cinema.service.ShoppingCartService;
import ua.com.cinema.service.UserService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public OrderController(OrderService orderService, UserService userService,
                           ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/complete")
    public void complete(@RequestParam Long userId) {
        User user = userService.getById(userId).get();
        orderService.completeOrder(shoppingCartService.getByUser(user));
    }

    @GetMapping
    public List<Order> getOrdersHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.getById(userId).get());
    }
}
