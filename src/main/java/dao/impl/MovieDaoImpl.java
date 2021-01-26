package dao.impl;

import dao.MovieDao;
import lib.Dao;
import java.util.List;
import model.Movie;
import org.apache.log4j.Logger;

@Dao
public class MovieDaoImpl implements MovieDao {
    private static final Logger logger = Logger.getLogger(MovieDaoImpl.class);

    @Override
    public Movie add(Movie movie) {
        return null;
    }

    @Override
    public List<Movie> getAll() {
        return null;
    }
}