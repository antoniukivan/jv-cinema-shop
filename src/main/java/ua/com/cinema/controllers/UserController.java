package ua.com.cinema.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cinema.model.User;
import ua.com.cinema.model.dto.UserRequestDto;
import ua.com.cinema.model.dto.UserResponseDto;
import ua.com.cinema.service.UserService;
import ua.com.cinema.service.mappers.UserMapper;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public void create(@RequestBody UserRequestDto userRequestDto) {
        userService.add(userMapper.getModelFromDto(userRequestDto));
    }

    @GetMapping
    public UserResponseDto findByEmail(@RequestParam(name = "email") String email) {
        User user = userService.findByEmail(email).get();
        return new UserResponseDto()
                .setId(user.getId())
                .setEmail(user.getEmail());
    }
}
