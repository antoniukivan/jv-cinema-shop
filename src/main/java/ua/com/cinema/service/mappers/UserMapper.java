package ua.com.cinema.service.mappers;

import org.springframework.stereotype.Component;
import ua.com.cinema.model.User;
import ua.com.cinema.model.dto.UserRequestDto;
import ua.com.cinema.model.dto.UserResponseDto;

@Component
public class UserMapper implements DtoMapper<User, UserRequestDto, UserResponseDto> {
    @Override
    public User getModelFromDto(UserRequestDto userRequestDto) {
        User user = new User();
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        return user;
    }

    @Override
    public UserResponseDto getDtoFromModel(User user) {
        return new UserResponseDto()
                .setId(user.getId())
                .setEmail(user.getEmail());
    }
}
