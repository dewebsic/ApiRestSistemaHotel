package com.angelsepulveda.apirestsistemahotel.services.contracts;

import com.angelsepulveda.apirestsistemahotel.dtos.DocumentTypeDto;
import com.angelsepulveda.apirestsistemahotel.models.DocumentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DocumentTypeService extends BaseService<DocumentType,DocumentTypeDto,Long>{

    Page<DocumentType> search(String filter, Pageable pageable) throws Exception;
}
