package com.angelsepulveda.apirestsistemahotel.validators;

import com.angelsepulveda.apirestsistemahotel.models.Room;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.RoomValidator;
import org.springframework.stereotype.Service;

@Service
public class RoomValidorImpl extends BaseValidatorImpl<Room> implements RoomValidator {
}
