package com.angelsepulveda.apirestsistemahotel.services.contracts;

import com.angelsepulveda.apirestsistemahotel.dtos.CategoryRoomDto;
import com.angelsepulveda.apirestsistemahotel.models.CategoryRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryRoomService extends BaseService<CategoryRoom, CategoryRoomDto,Long>{

    Page<CategoryRoom> search(String filter, Pageable pageable) throws Exception;
    void deactivate(Long id) throws Exception;
    void activate(Long id) throws Exception;
}
