package ua.com.cinema.dao;

import ua.com.cinema.model.Role;

public interface RoleDao {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
