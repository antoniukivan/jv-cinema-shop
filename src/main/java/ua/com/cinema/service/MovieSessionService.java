package ua.com.cinema.service;

import java.time.LocalDate;
import java.util.List;
import ua.com.cinema.model.MovieSession;

public interface MovieSessionService {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession movieSession);

    void update(MovieSession movieSession);

    MovieSession getById(Long id);

    void delete(Long id);
}
