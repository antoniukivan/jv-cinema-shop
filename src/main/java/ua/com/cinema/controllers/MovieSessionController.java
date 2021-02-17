package ua.com.cinema.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.cinema.model.MovieSession;
import ua.com.cinema.model.dto.MovieSessionRequestDto;
import ua.com.cinema.model.dto.MovieSessionResponseDto;
import ua.com.cinema.service.MovieSessionService;
import ua.com.cinema.service.mappers.MovieSessionMapper;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private static final String DATE_PATTERN = "dd.MM.yyyy";
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public void create(@RequestBody @Valid MovieSessionRequestDto movieSessionRequestDto) {
        movieSessionService.add(movieSessionMapper.getModelFromDto(movieSessionRequestDto));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody @Valid MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionMapper.getModelFromDto(movieSessionRequestDto);
        movieSession.setId(id);
        movieSessionService.update(movieSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailableSessions(
            @RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = DATE_PATTERN) LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::getDtoFromModel)
                .collect(Collectors.toList());
    }
}
