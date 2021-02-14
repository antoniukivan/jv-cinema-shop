package ua.com.cinema.service.mappers;

import org.springframework.stereotype.Component;
import ua.com.cinema.model.Movie;
import ua.com.cinema.model.dto.movie.MovieRequestDto;
import ua.com.cinema.model.dto.movie.MovieResponseDto;

@Component
public class MovieMapper implements DtoMapper<Movie, MovieRequestDto, MovieResponseDto> {
    public Movie getModelFromDto(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getTitle());
        return movie;
    }

    public MovieResponseDto getDtoFromModel(Movie movie) {
        return new MovieResponseDto()
                .setTitle(movie.getTitle())
                .setDescription(movie.getDescription());
    }
}
