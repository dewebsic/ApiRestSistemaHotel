package com.angelsepulveda.apirestsistemahotel.validators;


import com.angelsepulveda.apirestsistemahotel.models.DocumentType;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.DocumentTypeValidator;
import org.springframework.stereotype.Service;

@Service
public class DocumentTypeValidatorImpl extends BaseValidatorImpl<DocumentType> implements DocumentTypeValidator {
}
