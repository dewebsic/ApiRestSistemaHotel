package com.angelsepulveda.apirestsistemahotel.validators;

import com.angelsepulveda.apirestsistemahotel.models.ServiceRoom;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.ServiceRoomValidator;
import org.springframework.stereotype.Service;

@Service
public class ServiceRoomValidatorImpl extends BaseValidatorImpl<ServiceRoom> implements ServiceRoomValidator {
}
