package ua.com.cinema.dao;

import java.util.Optional;
import ua.com.cinema.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);

    Optional<User> getById(Long id);
}
