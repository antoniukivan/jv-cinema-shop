package ua.com.cinema.controllers;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cinema.model.dto.MovieRequestDto;
import ua.com.cinema.model.dto.MovieResponseDto;
import ua.com.cinema.service.MovieService;
import ua.com.cinema.service.mappers.MovieMapper;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    public void create(@RequestBody @Valid MovieRequestDto movieRequestDto) {
        movieService.add(movieMapper.getModelFromDto(movieRequestDto));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieMapper::getDtoFromModel)
                .collect(Collectors.toList());
    }
}
