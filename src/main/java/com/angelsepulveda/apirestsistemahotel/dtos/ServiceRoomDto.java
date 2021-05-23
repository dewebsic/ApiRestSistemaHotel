package com.angelsepulveda.apirestsistemahotel.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ServiceRoomDto {

    private Long id;
    private String name;
    private CategoryServiDto categoryServiDto;
    private Double price;
    private String description;
    private Boolean state;
}
