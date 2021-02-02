package ua.com.cinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import ua.com.cinema.lib.Injector;
import ua.com.cinema.model.CinemaHall;
import ua.com.cinema.model.Movie;
import ua.com.cinema.model.MovieSession;
import ua.com.cinema.service.CinemaHallService;
import ua.com.cinema.service.MovieService;
import ua.com.cinema.service.MovieSessionService;

public class Main {
    private static final Injector injector = Injector.getInstance("ua.com.cinema");
    private static final MovieService movieService
            = (MovieService) injector.getInstance(MovieService.class);
    private static final CinemaHallService cinemaHallService
            = (CinemaHallService) injector.getInstance(CinemaHallService.class);
    private static final MovieSessionService movieSessionService
            = (MovieSessionService) injector.getInstance(MovieSessionService.class);

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Dracula");
        movie = movieService.add(movie);
        movieService.getAll().forEach(System.out::println);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(100);
        cinemaHallService.add(cinemaHall);
        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setShowTime(LocalDateTime.now());
        movieSession.setCinemaHall(cinemaHall);
        movieSessionService.add(movieSession);
        System.out.println();
        Long movieId = movie.getId();
        movieSessionService.findAvailableSessions(movieId, LocalDate.now()).forEach(System.out::println);
    }
}
