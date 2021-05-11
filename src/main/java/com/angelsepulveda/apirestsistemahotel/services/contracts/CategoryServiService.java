package com.angelsepulveda.apirestsistemahotel.services.contracts;

import com.angelsepulveda.apirestsistemahotel.dtos.CategoryServiDto;
import com.angelsepulveda.apirestsistemahotel.models.CategoryServi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryServiService extends BaseService<CategoryServi, CategoryServiDto,Long>{

    Page<CategoryServi> search(String filter, Pageable pageable) throws Exception;
    void deactivate(Long id) throws Exception;
    void activate(Long id) throws Exception;
}
