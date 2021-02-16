package ua.com.cinema.service.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import ua.com.cinema.model.Order;
import ua.com.cinema.model.Ticket;
import ua.com.cinema.model.dto.OrderResponseDto;

@Component
public class OrderMapper implements DtoMapper<Order, OrderResponseDto> {
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
