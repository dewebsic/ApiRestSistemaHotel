package com.angelsepulveda.apirestsistemahotel.services.contracts;

import com.angelsepulveda.apirestsistemahotel.dtos.MethodPaymentDto;
import com.angelsepulveda.apirestsistemahotel.models.DocumentType;
import com.angelsepulveda.apirestsistemahotel.models.MethodPayment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MethodPaymentService extends BaseService<MethodPayment, MethodPaymentDto,Long>{

    Page<MethodPayment> search(String filter, Pageable pageable) throws Exception;
    void deactivate(Long id) throws Exception;
    void activate(Long id) throws Exception;
}
