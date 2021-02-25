package ua.com.cinema.dao;

import java.util.Optional;
import ua.com.cinema.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
