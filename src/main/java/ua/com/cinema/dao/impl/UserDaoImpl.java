package ua.com.cinema.dao.impl;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.cinema.dao.AbstractDao;
import ua.com.cinema.dao.UserDao;
import ua.com.cinema.exception.DataProcessingException;
import ua.com.cinema.model.User;

@Repository
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> findUserByEmailQuery
                    = session.createQuery("select u from User u join fetch u.roles "
                    + "where u.email = :email", User.class);
            findUserByEmailQuery.setParameter("email", email);
            return findUserByEmailQuery.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find user by email: "
                    + email, e);
        }
    }
}
