package ua.com.cinema.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cinema.model.Movie;
import ua.com.cinema.model.dto.movie.MovieRequestDto;
import ua.com.cinema.service.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public void create(@RequestBody MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getTitle());
        movieService.add(movie);
    }

    @GetMapping
    public List<Movie> getAll() {
        return
    }
}
