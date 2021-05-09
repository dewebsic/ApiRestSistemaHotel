package com.angelsepulveda.apirestsistemahotel.services.contracts;

import com.angelsepulveda.apirestsistemahotel.models.BaseModel;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseModel, ID extends Serializable> {

    public List<E> findAll() throws Exception;
    public E findById(ID id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(ID id, E entity) throws Exception;
}
