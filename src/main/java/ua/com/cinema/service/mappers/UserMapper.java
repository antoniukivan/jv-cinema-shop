package ua.com.cinema.service.mappers;

import org.springframework.stereotype.Component;
import ua.com.cinema.model.User;
import ua.com.cinema.model.dto.UserRequestDto;
import ua.com.cinema.model.dto.UserResponseDto;

@Component
public class UserMapper implements DtoMapper<User, UserRequestDto, UserResponseDto> {
    @Override
    public User getModelFromDto(UserRequestDto requestDto) {
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        return user;
    }

    @Override
    public UserResponseDto getDtoFromModel(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
