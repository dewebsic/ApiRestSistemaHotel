package com.angelsepulveda.apirestsistemahotel.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class VoucherTypeDto {

    private Long id;
    private String name;
    private String description;
    private Boolean state;
}
