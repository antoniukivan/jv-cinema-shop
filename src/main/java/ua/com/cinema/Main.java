package ua.com.cinema;

import ua.com.cinema.lib.Injector;
import ua.com.cinema.model.Movie;
import ua.com.cinema.service.MovieService;

public class Main {
    private static final Injector injector = Injector.getInstance("ua.com.cinema");

    public static void main(String[] args) {
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.getAll().forEach(System.out::println);

        Movie movie = new Movie();
        movie.setTitle("Dracula");
        movie = movieService.add(movie);

        movieService.getAll().forEach(System.out::println);
    }
}
