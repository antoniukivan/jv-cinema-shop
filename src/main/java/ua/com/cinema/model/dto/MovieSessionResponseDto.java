package ua.com.cinema.model.dto;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private String movieTitle;
    private Long cinemaHallId;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public MovieSessionResponseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public MovieSessionResponseDto setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
        return this;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public MovieSessionResponseDto setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
        return this;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public MovieSessionResponseDto setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
        return this;
    }
}
