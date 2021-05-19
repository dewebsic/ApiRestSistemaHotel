package com.angelsepulveda.apirestsistemahotel.security.validators;

import com.angelsepulveda.apirestsistemahotel.security.models.User;
import com.angelsepulveda.apirestsistemahotel.security.validators.contracts.UserValidator;
import com.angelsepulveda.apirestsistemahotel.validators.BaseValidatorImpl;
import org.springframework.stereotype.Service;

@Service
public class UserValidatorImpl extends BaseValidatorImpl<User> implements UserValidator {

}
