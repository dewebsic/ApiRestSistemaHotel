package com.angelsepulveda.apirestsistemahotel.services.contracts;

import com.angelsepulveda.apirestsistemahotel.dtos.VoucherTypeDto;
import com.angelsepulveda.apirestsistemahotel.models.VoucherType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VoucherTypeService extends BaseService<VoucherType, VoucherTypeDto,Long>{

    Page<VoucherType> search(String filter, Pageable pageable) throws Exception;
    void deactivate(Long id) throws Exception;
    void activate(Long id) throws Exception;
}
