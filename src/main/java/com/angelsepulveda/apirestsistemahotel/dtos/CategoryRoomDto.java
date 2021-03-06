package com.angelsepulveda.apirestsistemahotel.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CategoryRoomDto {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private Boolean state;
}
