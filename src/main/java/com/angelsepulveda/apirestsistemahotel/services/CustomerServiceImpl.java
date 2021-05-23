package com.angelsepulveda.apirestsistemahotel.services;

import com.angelsepulveda.apirestsistemahotel.dtos.CustomerDto;
import com.angelsepulveda.apirestsistemahotel.mappers.contracts.BaseMapper;
import com.angelsepulveda.apirestsistemahotel.models.Customer;
import com.angelsepulveda.apirestsistemahotel.repositories.BaseRepository;
import com.angelsepulveda.apirestsistemahotel.repositories.CustomerRepository;
import com.angelsepulveda.apirestsistemahotel.services.contracts.CustomerService;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.BaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl extends BaseServiceImpl<Customer, CustomerDto,Long> implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(BaseRepository<Customer,Long> repository, BaseValidator<Customer> validator,
                                   BaseMapper<Customer,CustomerDto> mapper){
        super(repository,validator,mapper);
    }

    @Override
    public void deactivate(Long id) throws Exception {
        try{
            this.customerRepository.changeState(false,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void activate(Long id) throws Exception {
        try{
            this.customerRepository.changeState(true,id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
