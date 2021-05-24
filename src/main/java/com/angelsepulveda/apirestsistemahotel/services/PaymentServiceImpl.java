package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.dtos.PaymentDto;
import com.angelsepulveda.apirestsistemahotel.exceptions.ModelNotFoundException;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.PaymentMapper;
import com.angelsepulveda.apirestsistemahotel.models.Payment;
import com.angelsepulveda.apirestsistemahotel.repositories.PaymentRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.PaymentService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.PaymentValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final PaymentValidator paymentValidator;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMapper paymentMapper,
                              PaymentValidator paymentValidator){
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
        this.paymentValidator = paymentValidator;
    }

    @Override
    public List<Payment> findAll() throws Exception {
        try{

            return this.paymentRepository.findAll();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Payment> findAll(Pageable pageable) throws Exception {
        try{
            return this.paymentRepository.findAll(pageable);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Payment findById(Long id) throws Exception {

        Optional<Payment> optionalEntity = this.paymentRepository.findById(id);

        //validamos si existe
        if(!optionalEntity.isPresent()){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }

        return optionalEntity.get();
    }

    @Override
    public Payment save(PaymentDto dto) throws Exception {
        try{

            Payment entity = this.paymentMapper.fromDto(dto);
            //validaciones
            this.paymentValidator.validate(entity);

            return this.paymentRepository.save(entity);

        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void cancel(Long id) throws Exception {

        try{
            this.paymentRepository.changeState("Anulado",id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }


    }
}
