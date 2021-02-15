package ua.com.cinema.service.mappers;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import ua.com.cinema.model.Order;
import ua.com.cinema.model.dto.OrderRequestDto;
import ua.com.cinema.model.dto.OrderResponseDto;
import ua.com.cinema.service.UserService;

@Component
public class OrderMapper implements DtoMapper<Order, OrderRequestDto, OrderResponseDto> {
    private final UserService userService;
    private final

    @Override
    public Order getModelFromDto(OrderRequestDto requestDto) {
        Order order = new Order();
        order.setUser(userService.findByEmail(requestDto.getEmail()).get());
        order.setPurchaseTime(LocalDateTime.parse(requestDto.getPurchaseTime()));
        order.set
        return order;
    }

    @Override
    public OrderResponseDto getDtoFromModel(Order entity) {
        return null;
    }
}
