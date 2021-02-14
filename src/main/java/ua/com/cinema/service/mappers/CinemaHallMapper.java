package ua.com.cinema.service.mappers;

import org.springframework.stereotype.Component;
import ua.com.cinema.model.CinemaHall;
import ua.com.cinema.model.dto.CinemaHallRequestDto;
import ua.com.cinema.model.dto.CinemaHallResponseDto;

@Component
public class CinemaHallMapper implements DtoMapper<CinemaHall, CinemaHallRequestDto,
        CinemaHallResponseDto> {
    @Override
    public CinemaHall getModelFromDto(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        return cinemaHall;
    }

    @Override
    public CinemaHallResponseDto getDtoFromModel(CinemaHall cinemaHall) {
        return new CinemaHallResponseDto()
                .setId(cinemaHall.getId())
                .setCapacity(cinemaHall.getCapacity());
    }
}
