package dao.impl;

import dao.MovieDao;
import lib.Dao;
import model.Movie;
import org.apache.log4j.Logger;

import java.util.List;

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