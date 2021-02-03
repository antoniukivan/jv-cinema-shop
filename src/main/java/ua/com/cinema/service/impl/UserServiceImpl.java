package ua.com.cinema.service.impl;

import java.util.Optional;
import ua.com.cinema.dao.UserDao;
import ua.com.cinema.lib.Inject;
import ua.com.cinema.lib.Service;
import ua.com.cinema.model.User;
import ua.com.cinema.util.HashUtil;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        byte[] salt = HashUtil.getSalt();
        String hashedPassword = HashUtil.hashPassword(user.getPassword(), salt);
        user.setPassword(hashedPassword);
        user.setSalt(salt);
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
