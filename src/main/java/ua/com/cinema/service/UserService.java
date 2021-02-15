package ua.com.cinema.service;

import java.util.Optional;
import ua.com.cinema.model.User;

public interface UserService {
    User add(User user);

    Optional<User> getById(Long id);

    Optional<User> findByEmail(String email);
}
