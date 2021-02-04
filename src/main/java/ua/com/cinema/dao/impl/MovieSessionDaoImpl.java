package ua.com.cinema.dao.impl;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.com.cinema.dao.MovieSessionDao;
import ua.com.cinema.exception.DataProcessingException;
import ua.com.cinema.lib.Dao;
import ua.com.cinema.model.MovieSession;
import ua.com.cinema.util.HibernateUtil;

@Dao
public class MovieSessionDaoImpl implements MovieSessionDao {
    @Override
    public MovieSession add(MovieSession movieSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert movie session entity: "
                    + movieSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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
