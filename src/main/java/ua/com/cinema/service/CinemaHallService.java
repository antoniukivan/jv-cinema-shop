package ua.com.cinema.service;

import java.util.List;
import ua.com.cinema.model.CinemaHall;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();

    CinemaHall getById(Long cinemaHallId);
}
