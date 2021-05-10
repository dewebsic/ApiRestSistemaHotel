package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.dtos.VoucherTypeDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.BaseMapper;
import com.angelsepulveda.apirestsistemahotel.models.VoucherType;
import com.angelsepulveda.apirestsistemahotel.repositories.BaseRepository;
import com.angelsepulveda.apirestsistemahotel.repositories.VoucherTypeRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.VoucherTypeService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.BaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VoucherTypeServiceImpl extends BaseServiceImpl<VoucherType, VoucherTypeDto,Long> implements VoucherTypeService {

    @Autowired
    private VoucherTypeRepository voucherTypeRepository;

    public VoucherTypeServiceImpl(BaseRepository<VoucherType,Long> repository, BaseValidator<VoucherType> validator,
                                   BaseMapper<VoucherType,VoucherTypeDto> mapper){
        super(repository,validator,mapper);
    }

    @Override
    public Page<VoucherType> search(String filter, Pageable pageable) throws Exception {
        try{
            return this.voucherTypeRepository.search(filter,pageable);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void deactivate(Long id) throws Exception {
        try{
            this.voucherTypeRepository.changeState(false,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void activate(Long id) throws Exception {
        try{
            this.voucherTypeRepository.changeState(true,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
