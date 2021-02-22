package ua.com.cinema.service;

import java.util.Optional;
import ua.com.cinema.model.Role;

public interface RoleService {
    void add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
