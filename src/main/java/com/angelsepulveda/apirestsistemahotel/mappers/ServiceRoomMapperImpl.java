package com.angelsepulveda.apirestsistemahotel.mappers;

import com.angelsepulveda.apirestsistemahotel.dtos.ServiceRoomDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.CategoryServiMapper;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.ServiceRoomMapper;
import com.angelsepulveda.apirestsistemahotel.models.ServiceRoom;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceRoomMapperImpl implements ServiceRoomMapper {

    private final CategoryServiMapper categoryServiMapper;

    public ServiceRoomMapperImpl(CategoryServiMapper categoryServiMapper){
        this.categoryServiMapper = categoryServiMapper;
    }

    @Override
    public ServiceRoomDto fromEntity(ServiceRoom entity) {
        if (entity == null) return null;

        return ServiceRoomDto.builder()
                .id(entity.getId())
                .categoryServiDto(categoryServiMapper.fromEntity(entity.getCategoryServi()))
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .state(entity.getState())
                .build();
    }

    @Override
    public ServiceRoom fromDto(ServiceRoomDto dto) {
        if(dto == null) return null;

        return ServiceRoom.builder()
                .id(dto.getId())
                .categoryServi(categoryServiMapper.fromDto(dto.getCategoryServiDto()))
                .name(dto.getName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .state(dto.getState())
                .build();
    }

    @Override
    public List<ServiceRoomDto> fromEntity(List<ServiceRoom> entities) {

        if(entities == null) return null;

        return entities.stream().map(entity -> {
            return ServiceRoomDto.builder()
                    .id(entity.getId())
                    .categoryServiDto(categoryServiMapper.fromEntity(entity.getCategoryServi()))
                    .name(entity.getName())
                    .price(entity.getPrice())
                    .description(entity.getDescription())
                    .state(entity.getState())
                    .build();

        }).collect(Collectors.toList());
    }

    @Override
    public List<ServiceRoom> fromDto(List<ServiceRoomDto> dtos) {

        if(dtos == null) return null;

        return dtos.stream().map(dto -> {
            return ServiceRoom.builder()
                    .id(dto.getId())
                    .categoryServi(categoryServiMapper.fromDto(dto.getCategoryServiDto()))
                    .name(dto.getName())
                    .price(dto.getPrice())
                    .description(dto.getDescription())
                    .state(dto.getState())
                    .build();

        }).collect(Collectors.toList());
    }
}
