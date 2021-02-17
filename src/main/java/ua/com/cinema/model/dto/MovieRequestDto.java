package ua.com.cinema.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MovieRequestDto {
    @NotNull
    @NotEmpty(message = "The movie title couldn't be empty")
    private String title;
    @NotEmpty(message = "The movie description couldn't be empty")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
