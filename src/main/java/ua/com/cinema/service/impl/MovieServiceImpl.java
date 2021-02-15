package ua.com.cinema.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import ua.com.cinema.dao.MovieDao;
import ua.com.cinema.model.Movie;
import ua.com.cinema.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public Movie getById(Long id) {
        return movieDao.getById(id).get();
    }
}
