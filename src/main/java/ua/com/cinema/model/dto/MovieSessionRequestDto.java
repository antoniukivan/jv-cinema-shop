package ua.com.cinema.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MovieSessionRequestDto {
    @NotNull(message = "The movie couldn't be null")
    private Long movieId;
    @NotNull(message = "The cinema hall couldn't be null")
    private Long cinemaHallId;
    @NotEmpty(message = "The movie session show time couldn't be empty")
    private String showTime;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
