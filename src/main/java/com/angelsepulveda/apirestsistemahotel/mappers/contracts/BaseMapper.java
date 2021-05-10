package com.angelsepulveda.apirestsistemahotel.mappers.contracts;

import java.util.List;

public interface BaseMapper<E,D>{

    public D fromEntity(E entity);
    public E fromDto(D dto);
    public List<D> fromEntity(List<E> entities);
    public List<E> fromDto(List<D> dtos);

}
