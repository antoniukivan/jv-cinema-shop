package service;

import java.util.List;
import model.Movie;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
