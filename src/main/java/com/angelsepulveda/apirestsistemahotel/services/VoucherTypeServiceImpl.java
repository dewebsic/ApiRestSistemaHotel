package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.exceptions.ModelNotFoundException;
import com.angelsepulveda.apirestsistemahotel.models.VoucherType;
import com.angelsepulveda.apirestsistemahotel.repositories.VoucherTypeRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.VoucherTypeService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.VoucherTypeValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherTypeServiceImpl implements VoucherTypeService {

    private final VoucherTypeRepository voucherTypeRepository;
    private final VoucherTypeValidator voucherTypeValidator;

    public VoucherTypeServiceImpl(VoucherTypeRepository voucherTypeRepository,
                                   VoucherTypeValidator voucherTypeValidator){
        this.voucherTypeRepository = voucherTypeRepository;
        this.voucherTypeValidator = voucherTypeValidator;
    }


    @Override
    public List<VoucherType> findAll() throws Exception {
        try{
            return this.voucherTypeRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public VoucherType findById(Long id) throws Exception {

        Optional<VoucherType> optionalVoucherType = this.voucherTypeRepository.findById(id);

        if(!optionalVoucherType.isPresent()){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }

        return optionalVoucherType.get();
    }

    @Override
    public VoucherType save(VoucherType entity) throws Exception {
        try{

            //validaciones
            this.voucherTypeValidator.validate(entity);

            return this.voucherTypeRepository.save(entity);

        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public VoucherType update(Long id, VoucherType entity) throws Exception {
        try {

            Optional<VoucherType> voucherTypeOptional = this.voucherTypeRepository.findById(id);

            if(!voucherTypeOptional.isPresent()){
                throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
            }

            VoucherType voucherTypeUpdate = voucherTypeOptional.get();
            voucherTypeUpdate = this.voucherTypeRepository.save(entity);
            return voucherTypeUpdate;

        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
