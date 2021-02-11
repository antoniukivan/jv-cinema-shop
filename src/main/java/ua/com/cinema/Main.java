package ua.com.cinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import ua.com.cinema.exception.AuthenticationException;
import ua.com.cinema.lib.Injector;
import ua.com.cinema.model.CinemaHall;
import ua.com.cinema.model.Movie;
import ua.com.cinema.model.MovieSession;
import ua.com.cinema.model.ShoppingCart;
import ua.com.cinema.model.User;
import ua.com.cinema.security.AuthenticationService;
import ua.com.cinema.service.CinemaHallService;
import ua.com.cinema.service.MovieService;
import ua.com.cinema.service.MovieSessionService;
import ua.com.cinema.service.OrderService;
import ua.com.cinema.service.ShoppingCartService;

public class Main {
    private static final Injector injector = Injector.getInstance("ua.com.cinema");
    private static final MovieService movieService
            = (MovieService) injector.getInstance(MovieService.class);
    private static final CinemaHallService cinemaHallService
            = (CinemaHallService) injector.getInstance(CinemaHallService.class);
    private static final MovieSessionService movieSessionService
            = (MovieSessionService) injector.getInstance(MovieSessionService.class);
    private static final AuthenticationService authenticationService
            = (AuthenticationService) injector.getInstance(AuthenticationService.class);
    private static final ShoppingCartService shoppingCartService
            = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
    private static final OrderService orderService
            = (OrderService) injector.getInstance(OrderService.class);

    public static void main(String[] args) {
        Movie dracula = new Movie();
        dracula.setTitle("Dracula");
        dracula = movieService.add(dracula);
        System.out.println("All movies:");
        movieService.getAll().forEach(System.out::println);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(100);
        cinemaHallService.add(cinemaHall);
        System.out.println("All cinema halls:");
        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(dracula);
        movieSession.setShowTime(LocalDateTime.now());
        movieSession.setCinemaHall(cinemaHall);
        movieSessionService.add(movieSession);
        MovieSession movieSession1 = new MovieSession();
        movieSession1.setMovie(dracula);
        movieSession1.setShowTime(LocalDateTime.now().plusHours(3));
        movieSession1.setCinemaHall(cinemaHall);
        movieSessionService.add(movieSession1);
        Long movieId = dracula.getId();
        List<MovieSession> availableSessions
                = movieSessionService.findAvailableSessions(movieId, LocalDate.now());
        System.out.println("Available sessions:");
        availableSessions.forEach(System.out::println);

        User alex = authenticationService.register("alex@mail.com", "123");
        User alex1 = authenticationService.register("alex1@mail.com", "123");
        System.out.println(alex);
        try {
            alex = authenticationService.login("alex@mail.com", "123");
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(alex);

        shoppingCartService.addSession(availableSessions.get(0), alex);
        shoppingCartService.addSession(availableSessions.get(1), alex);
        ShoppingCart alexShoppingCart = shoppingCartService.getByUser(alex);
        System.out.println(alexShoppingCart.getUser());
        alexShoppingCart.getTickets().forEach(System.out::println);

//        Order alexOrder = orderService.completeOrder(alexShoppingCart);
//        System.out.println(alexOrder);
//        System.out.println(alexShoppingCart);
//        orderService.getOrdersHistory(alex).forEach(System.out::println);
    }
}
