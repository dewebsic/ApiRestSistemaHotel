package com.angelsepulveda.apirestsistemahotel.mappers;

import com.angelsepulveda.apirestsistemahotel.dtos.PaymentDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.MethodPaymentMapper;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.PaymentMapper;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.ReservationMapper;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.VoucherTypeMapper;
import com.angelsepulveda.apirestsistemahotel.models.Payment;
import com.angelsepulveda.apirestsistemahotel.security.mappers.contracts.UserMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentMapperImpl implements PaymentMapper {

    private final UserMapper userMapper;
    private final ReservationMapper reservationMapper;
    private final MethodPaymentMapper methodPaymentMapper;
    private final VoucherTypeMapper voucherTypeMapper;

    public PaymentMapperImpl(UserMapper userMapper, ReservationMapper reservationMapper,
                             MethodPaymentMapper methodPaymentMapper, VoucherTypeMapper voucherTypeMapper) {
        this.userMapper = userMapper;
        this.reservationMapper = reservationMapper;
        this.methodPaymentMapper = methodPaymentMapper;
        this.voucherTypeMapper = voucherTypeMapper;
    }
    @Override
    public Payment fromDto(PaymentDto dto) {
        if(dto == null) return null;

        return Payment.builder()
                .id(dto.getId())
                .methodPayment(methodPaymentMapper.fromDto(dto.getMethodPaymentDto()))
                .user(userMapper.fromDto(dto.getUserDto()))
                .voucherType(voucherTypeMapper.fromDto(dto.getVoucherTypeDto()))
                .reservation(reservationMapper.fromDto(dto.getReservationDto()))
                .paymentDate(obtenerFechaYHoraActual())
                .subtotal(dto.getSubtotal())
                .discount(dto.getDiscount())
                .total(dto.getTotal())
                .state(dto.getState())
                .build();
    }

    @Override
    public List<Payment> fromDto(List<PaymentDto> dtos) {
        if(dtos == null) return null;

        return dtos.stream().map(dto -> {
            return Payment.builder()
                    .id(dto.getId())
                    .methodPayment(methodPaymentMapper.fromDto(dto.getMethodPaymentDto()))
                    .user(userMapper.fromDto(dto.getUserDto()))
                    .voucherType(voucherTypeMapper.fromDto(dto.getVoucherTypeDto()))
                    .reservation(reservationMapper.fromDto(dto.getReservationDto()))
                    .paymentDate(obtenerFechaYHoraActual())
                    .subtotal(dto.getSubtotal())
                    .discount(dto.getDiscount())
                    .total(dto.getTotal())
                    .state(dto.getState())
                    .build();

        }).collect(Collectors.toList());
    }

    private String obtenerFechaYHoraActual() {

        String formato = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        LocalDateTime ahora = LocalDateTime.now();
        return formateador.format(ahora);
    }
}
