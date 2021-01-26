package ua.com.cinema.service.impl;

import java.util.List;
import ua.com.cinema.dao.MovieDao;
import ua.com.cinema.lib.Inject;
import ua.com.cinema.lib.Service;
import ua.com.cinema.model.Movie;
import ua.com.cinema.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
