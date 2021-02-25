package ua.com.cinema.security;

import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.cinema.model.Role;
import ua.com.cinema.model.RoleName;
import ua.com.cinema.model.User;
import ua.com.cinema.service.RoleService;
import ua.com.cinema.service.UserService;

@Component
public class InjectData {
    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public InjectData(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void injectData() {
        Role admin = new Role();
        admin.setRoleName(RoleName.ADMIN);
        roleService.add(admin);

        Role user = new Role();
        admin.setRoleName(RoleName.USER);
        roleService.add(user);

        User joshua = new User();
        joshua.setEmail("joshua@mail.com");
        joshua.setPassword("12345678");
        joshua.setRoles(Set.of(admin));
        userService.add(joshua);
    }
}
