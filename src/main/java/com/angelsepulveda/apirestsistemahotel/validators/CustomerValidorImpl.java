package com.angelsepulveda.apirestsistemahotel.validators;

import com.angelsepulveda.apirestsistemahotel.models.Customer;
import com.angelsepulveda.apirestsistemahotel.validators.contracts.CustomerValidor;
import org.springframework.stereotype.Service;

@Service
public class CustomerValidorImpl extends BaseValidatorImpl<Customer> implements CustomerValidor {
}
