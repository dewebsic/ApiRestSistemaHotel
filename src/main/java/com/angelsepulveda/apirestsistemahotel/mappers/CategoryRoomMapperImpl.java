package com.angelsepulveda.apirestsistemahotel.mappers;

import com.angelsepulveda.apirestsistemahotel.dtos.CategoryRoomDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.CategoryRoomMapper;
import com.angelsepulveda.apirestsistemahotel.models.CategoryRoom;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryRoomMapperImpl implements CategoryRoomMapper {
    @Override
    public CategoryRoomDto fromEntity(CategoryRoom entity) {
        if(entity == null) return null;

        return CategoryRoomDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .state(entity.getState())
                .build();
    }

    @Override
    public CategoryRoom fromDto(CategoryRoomDto dto) {
        if(dto == null)  return null;

        return CategoryRoom.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .state(dto.getState())
                .build();
    }

    @Override
    public List<CategoryRoomDto> fromEntity(List<CategoryRoom> entities) {

        if(entities == null ) return null;

        return entities.stream()
                .map(e -> fromEntity(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryRoom> fromDto(List<CategoryRoomDto> dtos) {

        if(dtos == null) return null;

        return dtos.stream()
                .map(e -> fromDto(e))
                .collect(Collectors.toList());
    }
}
