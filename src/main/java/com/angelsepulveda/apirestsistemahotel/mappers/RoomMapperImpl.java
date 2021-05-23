package com.angelsepulveda.apirestsistemahotel.mappers;

import com.angelsepulveda.apirestsistemahotel.dtos.RoomDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.CategoryRoomMapper;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.RoomMapper;
import com.angelsepulveda.apirestsistemahotel.models.Room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomMapperImpl implements RoomMapper {

    private final CategoryRoomMapper categoryRoomMapper;

    public RoomMapperImpl(CategoryRoomMapper categoryRoomMapper) {
        this.categoryRoomMapper = categoryRoomMapper;
    }

    @Override
    public RoomDto fromEntity(Room entity) {

        if(entity == null) return null;

        return RoomDto.builder()
                .id(entity.getId())
                .categoryRoomDto(categoryRoomMapper.fromEntity(entity.getCategoryRoom()))
                .roomNumber(entity.getRoomNumber())
                .floorNumber(entity.getFloorNumber())
                .capacity(entity.getCapacity())
                .description(entity.getDescription())
                .state(entity.getState())
                .build();
    }

    @Override
    public Room fromDto(RoomDto dto) {

        if(dto == null) return null;

        return Room.builder()
                .id(dto.getId())
                .categoryRoom(categoryRoomMapper.fromDto(dto.getCategoryRoomDto()))
                .roomNumber(dto.getRoomNumber())
                .floorNumber(dto.getFloorNumber())
                .capacity(dto.getCapacity())
                .description(dto.getDescription())
                .state(dto.getState())
                .build();
    }

    @Override
    public List<RoomDto> fromEntity(List<Room> entities) {
        if(entities == null) return null;

        return entities.stream().map(entity -> {
            return RoomDto.builder()
                    .id(entity.getId())
                    .categoryRoomDto(categoryRoomMapper.fromEntity(entity.getCategoryRoom()))
                    .roomNumber(entity.getRoomNumber())
                    .floorNumber(entity.getFloorNumber())
                    .capacity(entity.getCapacity())
                    .description(entity.getDescription())
                    .state(entity.getState())
                    .build();

        }).collect(Collectors.toList());
    }

    @Override
    public List<Room> fromDto(List<RoomDto> dtos) {

        if(dtos == null) return null;

        return dtos.stream().map(dto -> {
            return Room.builder()
                    .id(dto.getId())
                    .categoryRoom(categoryRoomMapper.fromDto(dto.getCategoryRoomDto()))
                    .roomNumber(dto.getRoomNumber())
                    .floorNumber(dto.getFloorNumber())
                    .capacity(dto.getCapacity())
                    .description(dto.getDescription())
                    .state(dto.getState())
                    .build();

        }).collect(Collectors.toList());
    }
}
