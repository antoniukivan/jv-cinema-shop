package ua.com.cinema.service.mappers;

public interface ModelMapper<M, D> {
    M getModelFromDto(D requestDto);
}
