package ua.com.cinema.service.mappers;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import ua.com.cinema.model.MovieSession;
import ua.com.cinema.model.dto.MovieSessionRequestDto;
import ua.com.cinema.model.dto.MovieSessionResponseDto;
import ua.com.cinema.service.CinemaHallService;
import ua.com.cinema.service.MovieService;

@Component
public class MovieSessionMapper implements DtoMapper<MovieSession, MovieSessionRequestDto,
        MovieSessionResponseDto> {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @Override
    public MovieSession getModelFromDto(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.getById(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService
                .getById(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.parse(movieSessionRequestDto.getShowTime()));
        return movieSession;
    }

    @Override
    public MovieSessionResponseDto getDtoFromModel(MovieSession movieSession) {
        return new MovieSessionResponseDto()
                .setId(movieSession.getId())
                .setMovieTitle(movieSession.getMovie().getTitle())
                .setCinemaHallId(movieSession.getCinemaHall().getId())
                .setShowTime(movieSession.getShowTime());
    }
}
