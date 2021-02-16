package ua.com.cinema.service.mappers;

public interface DtoMapper<M, D> {
    D getDtoFromModel(M entity);
}
