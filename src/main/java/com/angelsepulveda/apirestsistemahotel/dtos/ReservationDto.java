package com.angelsepulveda.apirestsistemahotel.dtos;

import com.angelsepulveda.apirestsistemahotel.security.dtos.NewUserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ReservationDto {

    private Long id;
    private NewUserDto userDto;
    private RoomDto roomDto;
    private CustomerDto customerDto;
    private String start;
    private String end;
    private int guestNumber;
    private String state;
}
