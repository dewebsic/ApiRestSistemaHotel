package com.angelsepulveda.apirestsistemahotel.mappers;

import com.angelsepulveda.apirestsistemahotel.dtos.MethodPaymentDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.MethodPaymentMapper;
import com.angelsepulveda.apirestsistemahotel.models.MethodPayment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MethodPaymentMapperImpl implements MethodPaymentMapper {

    @Override
    public MethodPaymentDto fromEntity(MethodPayment entity) {
        return MethodPaymentDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .state(entity.getState())
                .build();
    }

    @Override
    public MethodPayment fromDto(MethodPaymentDto dto) {
        return MethodPayment.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .state(dto.getState())
                .build();
    }

    @Override
    public List<MethodPaymentDto> fromEntity(List<MethodPayment> entities) {
        return entities.stream()
                .map(e -> fromEntity(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<MethodPayment> fromDto(List<MethodPaymentDto> dtos) {
        return dtos.stream()
                .map(e -> fromDto(e))
                .collect(Collectors.toList());
    }
}
