package com.angelsepulveda.apirestsistemahotel.validators;

import com.angelsepulveda.apirestsistemahotel.models.VoucherType;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.VoucherTypeValidator;
import org.springframework.stereotype.Service;

@Service
public class VoucherTypeValidatorImpl extends BaseValidatorImpl<VoucherType> implements VoucherTypeValidator {
}
