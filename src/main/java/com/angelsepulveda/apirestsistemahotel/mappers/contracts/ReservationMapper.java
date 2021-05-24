package com.angelsepulveda.apirestsistemahotel.mappers.contracts;

import com.angelsepulveda.apirestsistemahotel.dtos.ReservationDto;
import com.angelsepulveda.apirestsistemahotel.models.Reservation;

import java.util.List;

public interface ReservationMapper {

    public Reservation fromDto(ReservationDto dto);
    public List<Reservation> fromDto(List<ReservationDto> dtos);
}
