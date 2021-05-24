package com.angelsepulveda.apirestsistemahotel.validators;

import com.angelsepulveda.apirestsistemahotel.models.Reservation;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.ReservationValidator;
import org.springframework.stereotype.Service;

@Service
public class ReservationValidatorImpl extends BaseValidatorImpl<Reservation> implements ReservationValidator {
}
