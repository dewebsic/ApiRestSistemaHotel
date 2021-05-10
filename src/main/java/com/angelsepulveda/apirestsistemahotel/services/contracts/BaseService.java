package com.angelsepulveda.apirestsistemahotel.services.contracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E,D, ID extends Serializable> {

    public List<D> findAll() throws Exception;
    public Page<E> findAll(Pageable pageable) throws Exception;
    public D findById(ID id) throws Exception;
    public D save(D dto) throws Exception;
    public D update(ID id, D dto) throws Exception;
}
