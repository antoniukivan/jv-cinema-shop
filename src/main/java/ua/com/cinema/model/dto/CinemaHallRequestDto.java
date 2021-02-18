package ua.com.cinema.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class CinemaHallRequestDto {
    @Min(50)
    @Max(500)
    private int capacity;
    @NotEmpty(message = "The cinema hall description couldn't be empty")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
