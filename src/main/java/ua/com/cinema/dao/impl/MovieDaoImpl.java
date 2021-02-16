package ua.com.cinema.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.cinema.dao.AbstractDao;
import ua.com.cinema.dao.MovieDao;
import ua.com.cinema.model.Movie;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie, Long> implements MovieDao {
    @Autowired
    public MovieDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Movie.class);
    }
}
