package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.dtos.DocumentTypeDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.BaseMapper;
import com.angelsepulveda.apirestsistemahotel.models.DocumentType;
import com.angelsepulveda.apirestsistemahotel.repositories.BaseRepository;
import com.angelsepulveda.apirestsistemahotel.repositories.DocumentTypeRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.DocumentTypeService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.BaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class DocumentTypeServiceImpl extends BaseServiceImpl<DocumentType,DocumentTypeDto,Long> implements DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public DocumentTypeServiceImpl(BaseRepository<DocumentType,Long> repository, BaseValidator<DocumentType> validator,
                                   BaseMapper<DocumentType,DocumentTypeDto> mapper){
        super(repository,validator,mapper);
    }


    @Override
    public Page<DocumentType> search(String filter, Pageable pageable) throws Exception {
        try{
            return this.documentTypeRepository.search(filter,pageable);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void deactivate(Long id) throws Exception {
        try{
            this.documentTypeRepository.changeState(false,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void activate(Long id) throws Exception {
        try{
            this.documentTypeRepository.changeState(true,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
