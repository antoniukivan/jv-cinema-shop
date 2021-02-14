package ua.com.cinema.service.mappers;

public interface DtoMapper<M, P, G> {
    M getModelFromDto(P value);

    G getDtoFromModel(M value);
}
