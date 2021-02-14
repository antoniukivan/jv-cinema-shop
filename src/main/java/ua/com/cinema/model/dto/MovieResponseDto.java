package ua.com.cinema.model.dto;

public class MovieResponseDto {
    private Long id;
    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    public MovieResponseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MovieResponseDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MovieResponseDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
