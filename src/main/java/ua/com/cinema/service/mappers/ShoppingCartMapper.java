package ua.com.cinema.service.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import ua.com.cinema.model.ShoppingCart;
import ua.com.cinema.model.Ticket;
import ua.com.cinema.model.dto.ShoppingCartResponseDto;

@Component
public class ShoppingCartMapper implements DtoMapper<ShoppingCart, ShoppingCartResponseDto> {
    @Override
    public ShoppingCartResponseDto getDtoFromModel(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setId(shoppingCart.getId());
        responseDto.setEmail(shoppingCart.getUser().getEmail());
        List<Long> ticketIds = shoppingCart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        responseDto.setTicketsIds(ticketIds);
        return responseDto;
    }
}
