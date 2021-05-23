package com.angelsepulveda.apirestsistemahotel.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CustomerDto {

    private Long id;
    private DocumentTypeDto documentTypeDto;
    private String businessName;
    private String commercialName;
    private String documentNumber;
    private String nationality;
    private String address;
    private String phoneNumber;
    private String email;
    private Boolean state;

}
