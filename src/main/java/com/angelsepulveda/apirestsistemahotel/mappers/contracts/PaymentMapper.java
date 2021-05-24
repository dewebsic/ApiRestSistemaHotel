package com.angelsepulveda.apirestsistemahotel.mappers.contracts;

import com.angelsepulveda.apirestsistemahotel.dtos.PaymentDto;
import com.angelsepulveda.apirestsistemahotel.models.Payment;

import java.util.List;

public interface PaymentMapper{

    public Payment fromDto(PaymentDto dto);
    public List<Payment> fromDto(List<PaymentDto> dtos);
}
