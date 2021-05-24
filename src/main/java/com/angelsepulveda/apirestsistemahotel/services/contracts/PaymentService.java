package com.angelsepulveda.apirestsistemahotel.services.contracts;

import com.angelsepulveda.apirestsistemahotel.dtos.PaymentDto;
import com.angelsepulveda.apirestsistemahotel.models.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentService {

    public List<Payment> findAll() throws Exception;
    public Page<Payment> findAll(Pageable pageable) throws Exception;
    public Payment findById(Long id) throws Exception;
    public Payment save(PaymentDto dto) throws Exception;
    void cancel(Long id) throws Exception;
}
