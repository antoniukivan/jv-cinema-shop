package ua.com.cinema.service;

import java.util.List;
import ua.com.cinema.model.Movie;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();

    Movie getById(Long id);
}
