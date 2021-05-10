package com.angelsepulveda.apirestsistemahotel.repositories;

import com.angelsepulveda.apirestsistemahotel.models.DocumentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends BaseRepository<DocumentType,Long>{

    @Query(value = "SELECT d FROM DocumentType d WHERE d.name LIKE %:filter% OR d.description LIKE %:filter%")
    Page<DocumentType> search(@Param("filter") String filter, Pageable pageable);
}
