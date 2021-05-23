package com.angelsepulveda.apirestsistemahotel.mappers;

import com.angelsepulveda.apirestsistemahotel.dtos.DocumentTypeDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.DocumentTypeMapper;
import com.angelsepulveda.apirestsistemahotel.models.DocumentType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentTypeMapperImpl implements DocumentTypeMapper {

    @Override
    public DocumentTypeDto fromEntity(DocumentType entity) {

        if(entity == null) return null;

        return DocumentTypeDto.builder()
                     .id(entity.getId())
                     .name(entity.getName())
                     .description(entity.getDescription())
                     .state(entity.getState())
                     .build();

    }

    @Override
    public DocumentType fromDto(DocumentTypeDto dto) {

        if(dto == null ) return null;

        return DocumentType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .state(dto.getState())
                .build();
    }

    @Override
    public List<DocumentTypeDto> fromEntity(List<DocumentType> entities) {

        if(entities == null) return null;

        return entities.stream()
                .map(e -> fromEntity(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<DocumentType> fromDto(List<DocumentTypeDto> dtos) {

        if(dtos == null) return null;

        return dtos.stream()
                .map(e -> fromDto(e))
                .collect(Collectors.toList());
    }
}
