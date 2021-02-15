package ua.com.cinema.service.mappers;

public interface DtoMapper<M, P, G> {
    M getModelFromDto(P requestDto);

    G getDtoFromModel(M entity);
}
