package ua.com.cinema.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import ua.com.cinema.dao.CinemaHallDao;
import ua.com.cinema.model.CinemaHall;
import ua.com.cinema.service.CinemaHallService;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    private final CinemaHallDao cinemaHallDao;

    public CinemaHallServiceImpl(CinemaHallDao cinemaHallDao) {
        this.cinemaHallDao = cinemaHallDao;
    }

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }

    @Override
    public CinemaHall getById(Long cinemaHallId) {
        return cinemaHallDao.getById(cinemaHallId).get();
    }
}
