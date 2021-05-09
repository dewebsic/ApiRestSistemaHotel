package com.angelsepulveda.apirestsistemahotel.validators.contracts;

import com.angelsepulveda.apirestsistemahotel.models.BaseModel;

public interface BaseValidator<E extends BaseModel>{

    public void validate(E entity) throws Exception;
}
