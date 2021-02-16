package ua.com.cinema.dao;

import java.util.List;
import java.util.Optional;
import ua.com.cinema.model.Movie;

public interface MovieDao {
    Movie add(Movie entity);

    List<Movie> getAll();

    Optional<Movie> getById(Long id);
}
