package ua.com.cinema.security;

import ua.com.cinema.exception.AuthenticationException;
import ua.com.cinema.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
