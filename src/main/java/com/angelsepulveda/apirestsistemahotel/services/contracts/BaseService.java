package com.angelsepulveda.apirestsistemahotel.services.contracts;

import java.io.Serializable;
import java.util.List;

public interface BaseService<D, ID extends Serializable> {

    public List<D> findAll() throws Exception;
    public D findById(ID id) throws Exception;
    public D save(D dto) throws Exception;
    public D update(ID id, D dto) throws Exception;
}
