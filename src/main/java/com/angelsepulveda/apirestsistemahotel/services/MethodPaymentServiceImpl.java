package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.dtos.MethodPaymentDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.BaseMapper;
import com.angelsepulveda.apirestsistemahotel.models.MethodPayment;
import com.angelsepulveda.apirestsistemahotel.repositories.BaseRepository;
import com.angelsepulveda.apirestsistemahotel.repositories.MethodPaymentRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.MethodPaymentService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.BaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MethodPaymentServiceImpl extends BaseServiceImpl<MethodPayment, MethodPaymentDto,Long> implements MethodPaymentService {

    @Autowired
    private MethodPaymentRepository  methodPaymentRepository;

    public MethodPaymentServiceImpl(BaseRepository<MethodPayment,Long> repository, BaseValidator<MethodPayment> validator,
                                   BaseMapper<MethodPayment,MethodPaymentDto> mapper){
        super(repository,validator,mapper);
    }

    @Override
    public Page<MethodPayment> search(String filter, Pageable pageable) throws Exception {
        try{
            return this.methodPaymentRepository.search(filter,pageable);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void deactivate(Long id) throws Exception {
        try{
            this.methodPaymentRepository.changeState(false,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void activate(Long id) throws Exception {
        try{
            this.methodPaymentRepository.changeState(true,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
