package ua.com.cinema.dao.impl;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.cinema.dao.AbstractDao;
import ua.com.cinema.dao.MovieSessionDao;
import ua.com.cinema.exception.DataProcessingException;
import ua.com.cinema.model.MovieSession;

@Repository
public class MovieSessionDaoImpl extends AbstractDao<MovieSession, Long>
        implements MovieSessionDao {
    @Autowired
    public MovieSessionDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, MovieSession.class);
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<MovieSession> getAllMovieSessionsQuery
                    = session.createQuery("from MovieSession ms "
                    + "where ms.movie.id = :movieId "
                    + "and DATE_FORMAT(ms.showTime,'%Y-%m-%d') = :date", MovieSession.class);
            getAllMovieSessionsQuery.setParameter("movieId", movieId);
            getAllMovieSessionsQuery.setParameter("date", date.toString());
            return getAllMovieSessionsQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find movie sessions by movie ID: "
                    + movieId + " and by date: " + date, e);
        }
    }
}
