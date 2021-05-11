package com.angelsepulveda.apirestsistemahotel.mappers;

import com.angelsepulveda.apirestsistemahotel.dtos.CategoryServiDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.CategoryServiMapper;
import com.angelsepulveda.apirestsistemahotel.models.CategoryServi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiMapperImpl implements CategoryServiMapper {

    @Override
    public CategoryServiDto fromEntity(CategoryServi entity) {
        return CategoryServiDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .state(entity.getState())
                .build();
    }

    @Override
    public CategoryServi fromDto(CategoryServiDto dto) {
        return CategoryServi.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .state(dto.getState())
                .build();
    }

    @Override
    public List<CategoryServiDto> fromEntity(List<CategoryServi> entities) {
        return entities.stream()
                .map(e -> fromEntity(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryServi> fromDto(List<CategoryServiDto> dtos) {
        return dtos.stream()
                .map(e -> fromDto(e))
                .collect(Collectors.toList());
    }
}
