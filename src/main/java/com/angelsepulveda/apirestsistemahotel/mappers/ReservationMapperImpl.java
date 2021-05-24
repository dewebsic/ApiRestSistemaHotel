package com.angelsepulveda.apirestsistemahotel.mappers;

import com.angelsepulveda.apirestsistemahotel.dtos.ReservationDto;
import com.angelsepulveda.apirestsistemahotel.dtos.RoomDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.CustomerMapper;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.ReservationMapper;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.RoomMapper;
import com.angelsepulveda.apirestsistemahotel.models.Reservation;
import com.angelsepulveda.apirestsistemahotel.models.Room;
import com.angelsepulveda.apirestsistemahotel.security.mappers.contracts.UserMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationMapperImpl implements ReservationMapper {

    private final CustomerMapper customerMapper;
    private final UserMapper userMapper;
    private final RoomMapper roomMapper;

    public ReservationMapperImpl(CustomerMapper customerMapper, UserMapper userMapper, RoomMapper roomMapper) {
        this.customerMapper = customerMapper;
        this.userMapper = userMapper;
        this.roomMapper = roomMapper;
    }

    @Override
    public Reservation fromDto(ReservationDto dto) {

        if(dto == null) return null;

        return Reservation.builder()
                .id(dto.getId())
                .customer(customerMapper.fromDto(dto.getCustomerDto()))
                .room(roomMapper.fromDto(dto.getRoomDto()))
                .user(userMapper.fromDto(dto.getUserDto()))
                .registrationDate(obtenerFechaYHoraActual())
                .start(dto.getStart())
                .end(dto.getEnd())
                .guestNumber(dto.getGuestNumber())
                .state(dto.getState())
                .build();
    }


    @Override
    public List<Reservation> fromDto(List<ReservationDto> dtos) {
        if(dtos == null) return null;

        return dtos.stream().map(dto -> {
            return Reservation.builder()
                    .id(dto.getId())
                    .customer(customerMapper.fromDto(dto.getCustomerDto()))
                    .room(roomMapper.fromDto(dto.getRoomDto()))
                    .user(userMapper.fromDto(dto.getUserDto()))
                    .registrationDate(obtenerFechaYHoraActual())
                    .start(dto.getStart())
                    .end(dto.getEnd())
                    .guestNumber(dto.getGuestNumber())
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
