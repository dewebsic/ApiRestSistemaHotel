package com.angelsepulveda.apirestsistemahotel.validators;

import com.angelsepulveda.apirestsistemahotel.models.Payment;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.PaymentValidator;
import org.springframework.stereotype.Service;

@Service
public class PaymentValidatorImpl extends BaseValidatorImpl<Payment> implements PaymentValidator {
}
