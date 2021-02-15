package ua.com.cinema.service.mappers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import ua.com.cinema.model.Order;
import ua.com.cinema.model.Ticket;
import ua.com.cinema.model.dto.OrderRequestDto;
import ua.com.cinema.model.dto.OrderResponseDto;
import ua.com.cinema.service.TicketService;
import ua.com.cinema.service.UserService;

@Component
public class OrderMapper implements DtoMapper<Order, OrderRequestDto, OrderResponseDto> {
    private final UserService userService;
    private final TicketService ticketService;

    public OrderMapper(UserService userService, TicketService ticketService) {
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @Override
    public Order getModelFromDto(OrderRequestDto requestDto) {
        Order order = new Order();
        order.setUser(userService.findByEmail(requestDto.getEmail()).get());
        order.setPurchaseTime(LocalDateTime.parse(requestDto.getPurchaseTime()));
        List<Ticket> tickets = requestDto.getTicketIds().stream()
                .map(ticketService::getById)
                .map(Optional::get)
                .collect(Collectors.toList());
        order.setTickets(tickets);
        return order;
    }

    @Override
    public OrderResponseDto getDtoFromModel(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setPurchaseTime(order.getPurchaseTime().toString());
        List<Long> ticketsId = order.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        orderResponseDto.setTickets(ticketsId);
        return orderResponseDto;
    }
}
