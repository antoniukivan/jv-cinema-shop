package ua.com.cinema.service.impl;

import java.util.Optional;
import ua.com.cinema.model.User;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);
}
