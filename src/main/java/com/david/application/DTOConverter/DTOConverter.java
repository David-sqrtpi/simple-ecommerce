package com.david.application.DTOConverter;

import java.util.List;
import java.util.stream.Collectors;

public interface DTOConverter<E, D> {
    E fromDTO(D DTO);
    D fromEntity(E entity);

    default List<E> fromDTO(List<D> DTOS) {
        if (DTOS == null) {
            return null;
        } else {
            return DTOS.stream().map(this::fromDTO).collect(Collectors.toList());
        }
    }

    default List<D> fromEntity(List<E> entities) {
        if (entities == null) {
            return null;
        } else {
            return entities.stream().map(this::fromEntity).collect(Collectors.toList());
        }
    }
}