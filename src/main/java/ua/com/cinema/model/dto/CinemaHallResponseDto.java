package ua.com.cinema.model.dto;

public class CinemaHallResponseDto {
    private Long id;
    private int capacity;

    public Long getId() {
        return id;
    }

    public CinemaHallResponseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public CinemaHallResponseDto setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }
}
