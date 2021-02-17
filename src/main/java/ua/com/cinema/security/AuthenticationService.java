package ua.com.cinema.security;

import ua.com.cinema.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
