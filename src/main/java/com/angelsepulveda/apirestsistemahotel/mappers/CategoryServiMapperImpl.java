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

        if(entity == null) return null;

        return CategoryServiDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .state(entity.getState())
                .build();
    }

    @Override
    public CategoryServi fromDto(CategoryServiDto dto) {

        if(dto == null)  return null;

        return CategoryServi.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .state(dto.getState())
                .build();
    }

    @Override
    public List<CategoryServiDto> fromEntity(List<CategoryServi> entities) {

        if(entities == null ) return null;

        return entities.stream()
                .map(e -> fromEntity(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryServi> fromDto(List<CategoryServiDto> dtos) {

        if(dtos == null) return null;

        return dtos.stream()
                .map(e -> fromDto(e))
                .collect(Collectors.toList());
    }
}
