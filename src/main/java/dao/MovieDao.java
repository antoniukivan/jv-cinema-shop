package dao;

import java.util.List;
import model.Movie;

public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();
}
