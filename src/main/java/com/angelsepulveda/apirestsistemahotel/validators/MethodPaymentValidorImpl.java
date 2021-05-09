package com.angelsepulveda.apirestsistemahotel.validators;

import com.angelsepulveda.apirestsistemahotel.models.MethodPayment;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.MethodPaymentValidator;
import org.springframework.stereotype.Service;

@Service
public class MethodPaymentValidorImpl extends BaseValidatorImpl<MethodPayment> implements MethodPaymentValidator {
}
