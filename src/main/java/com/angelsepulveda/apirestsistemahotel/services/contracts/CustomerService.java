package com.angelsepulveda.apirestsistemahotel.services.contracts;

import com.angelsepulveda.apirestsistemahotel.dtos.CustomerDto;
import com.angelsepulveda.apirestsistemahotel.models.Customer;


public interface CustomerService extends BaseService<Customer, CustomerDto,Long>{

    void deactivate(Long id) throws Exception;
    void activate(Long id) throws Exception;
}
