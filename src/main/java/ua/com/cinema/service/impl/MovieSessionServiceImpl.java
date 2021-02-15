package ua.com.cinema.service.impl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import ua.com.cinema.dao.MovieSessionDao;
import ua.com.cinema.model.MovieSession;
import ua.com.cinema.service.MovieSessionService;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionDao movieSessionDao;

    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        return movieSessionDao.add(movieSession);
    }

    @Override
    public void update(MovieSession movieSession) {
        movieSessionDao.update(movieSession);
    }

    @Override
    public MovieSession getById(Long id) {
        return movieSessionDao.getById(id).get();
    }

    @Override
    public void delete(Long id) {
        movieSessionDao.delete(id);
    }
}
