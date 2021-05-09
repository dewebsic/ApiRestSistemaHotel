package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.exceptions.ModelNotFoundException;
import com.angelsepulveda.apirestsistemahotel.models.DocumentType;
import com.angelsepulveda.apirestsistemahotel.repositories.DocumentTypeRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.DocumentTypeService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.DocumentTypeValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {


    private final DocumentTypeRepository documentTypeRepository;
    private final DocumentTypeValidator documentTypeValidator;

    public DocumentTypeServiceImpl(DocumentTypeRepository documentTypeRepository,
                                   DocumentTypeValidator documentTypeValidator){
        this.documentTypeRepository = documentTypeRepository;
        this.documentTypeValidator = documentTypeValidator;
    }


    @Override
    public List<DocumentType> findAll() throws Exception {
        try{
            return this.documentTypeRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public DocumentType findById(Long id) throws Exception {

        Optional<DocumentType> optionalDocumentType = this.documentTypeRepository.findById(id);

        if(!optionalDocumentType.isPresent()){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }

        return optionalDocumentType.get();
    }

    @Override
    public DocumentType save(DocumentType entity) throws Exception {
        try{

            //validaciones
            this.documentTypeValidator.validate(entity);

            return this.documentTypeRepository.save(entity);

        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public DocumentType update(Long id, DocumentType entity) throws Exception {
        try {

            Optional<DocumentType> documentTypeOptional = this.documentTypeRepository.findById(id);

            if(!documentTypeOptional.isPresent()){
                throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
            }

            DocumentType documentTypeUpdate = documentTypeOptional.get();
            documentTypeUpdate = this.documentTypeRepository.save(entity);
            return documentTypeUpdate;

        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
