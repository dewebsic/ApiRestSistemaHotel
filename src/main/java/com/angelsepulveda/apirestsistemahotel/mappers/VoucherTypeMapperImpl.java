package com.angelsepulveda.apirestsistemahotel.mappers;

import com.angelsepulveda.apirestsistemahotel.dtos.VoucherTypeDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.VoucherTypeMapper;
import com.angelsepulveda.apirestsistemahotel.models.VoucherType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoucherTypeMapperImpl implements VoucherTypeMapper {
    @Override
    public VoucherTypeDto fromEntity(VoucherType entity) {
        return VoucherTypeDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .state(entity.getState())
                .build();

    }

    @Override
    public VoucherType fromDto(VoucherTypeDto dto) {
        return VoucherType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .state(dto.getState())
                .build();
    }

    @Override
    public List<VoucherTypeDto> fromEntity(List<VoucherType> entities) {

        return entities.stream()
                .map(e -> fromEntity(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<VoucherType> fromDto(List<VoucherTypeDto> dtos) {

        return dtos.stream()
                .map(e -> fromDto(e))
                .collect(Collectors.toList());
    }
}
