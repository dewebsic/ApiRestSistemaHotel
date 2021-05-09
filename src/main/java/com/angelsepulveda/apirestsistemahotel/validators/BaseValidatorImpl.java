package com.angelsepulveda.apirestsistemahotel.validators;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.angelsepulveda.apirestsistemahotel.models.BaseModel;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.BaseValidator;

import java.util.Set;

public abstract class BaseValidatorImpl<E extends BaseModel> implements BaseValidator<E> {

    public void validate(E entity) throws Exception{

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<E>> violations = validator.validate(entity);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }
}
