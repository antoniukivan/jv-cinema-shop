package ua.com.cinema.dao;

import java.util.List;
import java.util.Optional;
import ua.com.cinema.model.CinemaHall;

public interface CinemaHallDao {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();

    Optional<CinemaHall> getById(Long cinemaHallId);
}
