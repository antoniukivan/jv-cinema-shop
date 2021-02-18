package ua.com.cinema.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cinema.model.User;
import ua.com.cinema.model.dto.ShoppingCartResponseDto;
import ua.com.cinema.service.MovieSessionService;
import ua.com.cinema.service.ShoppingCartService;
import ua.com.cinema.service.UserService;
import ua.com.cinema.service.mappers.ShoppingCartMapper;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;
    private final ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  MovieSessionService movieSessionService,
                                  ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(Authentication authentication, @RequestParam Long movieSessionId) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        shoppingCartService.addSession(movieSessionService.getById(movieSessionId),
                userService.findByEmail(principal.getUsername()).get());
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication authentication) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        User user = userService.findByEmail(principal.getUsername()).get();
        return shoppingCartMapper.getDtoFromModel(shoppingCartService.getByUser(user));
    }
}
