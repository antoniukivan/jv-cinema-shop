package ua.com.cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.cinema.dao.RoleDao;
import ua.com.cinema.model.Role;
import ua.com.cinema.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName).get();
    }
}
