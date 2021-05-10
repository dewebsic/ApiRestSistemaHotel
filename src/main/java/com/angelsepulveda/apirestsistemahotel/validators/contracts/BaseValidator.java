package com.angelsepulveda.apirestsistemahotel.validators.contracts;

public interface BaseValidator<E>{

    public void validate(E entity) throws Exception;
}
