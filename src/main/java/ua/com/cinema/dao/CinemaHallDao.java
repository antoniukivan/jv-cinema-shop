package ua.com.cinema.dao;

import java.util.List;
import ua.com.cinema.model.CinemaHall;

public interface CinemaHallDao {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();
}
