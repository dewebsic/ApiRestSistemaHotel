package com.angelsepulveda.apirestsistemahotel.mappers;

import com.angelsepulveda.apirestsistemahotel.dtos.CustomerDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.CustomerMapper;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.DocumentTypeMapper;
import com.angelsepulveda.apirestsistemahotel.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerMapperImpl implements CustomerMapper {

    private final DocumentTypeMapper documentTypeMapper;

    public CustomerMapperImpl(DocumentTypeMapper documentTypeMapper) {
        this.documentTypeMapper = documentTypeMapper;
    }

    @Override
    public CustomerDto fromEntity(Customer entity) {
        return CustomerDto.builder()
                .id(entity.getId())
                .businessName(entity.getBusinessName())
                .documentTypeDto(documentTypeMapper.fromEntity(entity.getDocumentType()))
                .commercialName(entity.getCommercialName())
                .documentNumber(entity.getDocumentNumber())
                .nationality(entity.getNationality())
                .address(entity.getAddress())
                .phoneNumber(entity.getPhoneNumber())
                .email(entity.getEmail())
                .state(entity.getState())
                .build();
    }

    @Override
    public Customer fromDto(CustomerDto dto) {
        return Customer.builder()
                .id(dto.getId())
                .documentType(documentTypeMapper.fromDto(dto.getDocumentTypeDto()))
                .businessName(dto.getBusinessName())
                .commercialName(dto.getCommercialName())
                .documentNumber(dto.getDocumentNumber())
                .nationality(dto.getNationality())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .state(dto.getState())
                .build();
    }

    @Override
    public List<CustomerDto> fromEntity(List<Customer> entities) {
        if(entities == null) return null;

        return entities.stream().map(entity -> {
            return CustomerDto.builder()
                    .id(entity.getId())
                    .id(entity.getId())
                    .businessName(entity.getBusinessName())
                    .documentTypeDto(documentTypeMapper.fromEntity(entity.getDocumentType()))
                    .commercialName(entity.getCommercialName())
                    .documentNumber(entity.getDocumentNumber())
                    .nationality(entity.getNationality())
                    .address(entity.getAddress())
                    .phoneNumber(entity.getPhoneNumber())
                    .email(entity.getEmail())
                    .state(entity.getState())
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public List<Customer> fromDto(List<CustomerDto> dtos) {

        if(dtos == null) return null;

        return dtos.stream().map(dto -> {
            return Customer.builder()
                    .id(dto.getId())
                    .documentType(documentTypeMapper.fromDto(dto.getDocumentTypeDto()))
                    .businessName(dto.getBusinessName())
                    .commercialName(dto.getCommercialName())
                    .documentNumber(dto.getDocumentNumber())
                    .nationality(dto.getNationality())
                    .address(dto.getAddress())
                    .phoneNumber(dto.getPhoneNumber())
                    .email(dto.getEmail())
                    .state(dto.getState())
                    .build();

        }).collect(Collectors.toList());
    }
}
