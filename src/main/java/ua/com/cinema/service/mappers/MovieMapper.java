package ua.com.cinema.service.mappers;

import org.springframework.stereotype.Component;
import ua.com.cinema.model.Movie;
import ua.com.cinema.model.dto.MovieRequestDto;
import ua.com.cinema.model.dto.MovieResponseDto;

@Component
public class MovieMapper implements DtoMapper<Movie, MovieResponseDto>,
        ModelMapper<Movie, MovieRequestDto> {
    public Movie getModelFromDto(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }

    public MovieResponseDto getDtoFromModel(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(movie.getId());
        movieResponseDto.setTitle(movie.getTitle());
        movieResponseDto.setDescription(movie.getDescription());
        return movieResponseDto;
    }
}
