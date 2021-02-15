package ua.com.cinema.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cinema.model.User;
import ua.com.cinema.model.dto.OrderResponseDto;
import ua.com.cinema.service.OrderService;
import ua.com.cinema.service.ShoppingCartService;
import ua.com.cinema.service.UserService;
import ua.com.cinema.service.mappers.OrderMapper;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final OrderMapper orderMapper;
    private final ShoppingCartService shoppingCartService;

    public OrderController(OrderService orderService, UserService userService,
                           OrderMapper orderMapper, ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.userService = userService;
        this.orderMapper = orderMapper;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/complete")
    public void complete(@RequestParam Long userId) {
        User user = userService.getById(userId).get();
        orderService.completeOrder(shoppingCartService.getByUser(user));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        User user = userService.getById(userId).get();
        return orderService.getOrdersHistory(user).stream()
                .map(orderMapper::getDtoFromModel)
                .collect(Collectors.toList());
    }
}
