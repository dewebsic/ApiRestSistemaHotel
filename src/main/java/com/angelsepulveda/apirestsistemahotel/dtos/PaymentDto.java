package com.angelsepulveda.apirestsistemahotel.dtos;

import com.angelsepulveda.apirestsistemahotel.security.dtos.NewUserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PaymentDto {

    private Long id;
    private NewUserDto userDto;
    private MethodPaymentDto methodPaymentDto;
    private ReservationDto reservationDto;
    private VoucherTypeDto voucherTypeDto;
    private Double subtotal;
    private Double discount;
    private Double total;
    private String state;
}
