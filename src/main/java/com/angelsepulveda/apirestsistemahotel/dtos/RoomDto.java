package com.angelsepulveda.apirestsistemahotel.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RoomDto {

    private Long id;
    private CategoryRoomDto categoryRoomDto;
    private String roomNumber;
    private String floorNumber;
    private int capacity;
    private String description;
    private Boolean state;
}
