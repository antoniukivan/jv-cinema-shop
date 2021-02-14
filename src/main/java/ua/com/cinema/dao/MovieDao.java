package ua.com.cinema.dao;

import java.util.List;
import ua.com.cinema.model.Movie;

public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();

    Movie getById(Long id);
}
