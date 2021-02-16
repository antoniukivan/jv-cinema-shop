package ua.com.cinema.service.mappers;

import org.springframework.stereotype.Component;
import ua.com.cinema.model.CinemaHall;
import ua.com.cinema.model.dto.CinemaHallRequestDto;
import ua.com.cinema.model.dto.CinemaHallResponseDto;

@Component
public class CinemaHallMapper implements DtoMapper<CinemaHall, CinemaHallResponseDto>,
        ModelMapper<CinemaHall, CinemaHallRequestDto> {
    @Override
    public CinemaHall getModelFromDto(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }

    @Override
    public CinemaHallResponseDto getDtoFromModel(CinemaHall cinemaHall) {
        CinemaHallResponseDto responseDto = new CinemaHallResponseDto();
        responseDto.setId(cinemaHall.getId());
        responseDto.setCapacity(cinemaHall.getCapacity());
        responseDto.setDescription(cinemaHall.getDescription());
        return responseDto;
    }
}
