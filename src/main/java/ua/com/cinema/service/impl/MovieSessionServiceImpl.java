package ua.com.cinema.service.impl;

import java.time.LocalDate;
import java.util.List;
import ua.com.cinema.dao.MovieSessionDao;
import ua.com.cinema.lib.Inject;
import ua.com.cinema.model.MovieSession;
import ua.com.cinema.service.MovieSessionService;

public class MovieSessionServiceImpl implements MovieSessionService {
    @Inject
    private MovieSessionDao movieSessionDao;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        return movieSessionDao.add(movieSession);
    }
}
