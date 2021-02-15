package ua.com.cinema.service.mappers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import ua.com.cinema.model.ShoppingCart;
import ua.com.cinema.model.Ticket;
import ua.com.cinema.model.dto.ShoppingCartRequestDto;
import ua.com.cinema.model.dto.ShoppingCartResponseDto;
import ua.com.cinema.service.TicketService;
import ua.com.cinema.service.UserService;

@Component
public class ShoppingCartMapper implements DtoMapper<ShoppingCart,
        ShoppingCartRequestDto, ShoppingCartResponseDto> {
    private final UserService userService;
    private final TicketService ticketService;

    public ShoppingCartMapper(UserService userService, TicketService ticketService) {
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @Override
    public ShoppingCart getModelFromDto(ShoppingCartRequestDto requestDto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(userService.findByEmail(requestDto.getEmail()).get());
        List<Ticket> tickets = requestDto.getTicketsIds().stream()
                .map(ticketService::getById)
                .map(Optional::get)
                .collect(Collectors.toList());
        shoppingCart.setTickets(tickets);
        return shoppingCart;
    }

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
