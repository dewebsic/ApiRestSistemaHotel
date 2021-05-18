package com.angelsepulveda.apirestsistemahotel.security.services.contracts;

import com.angelsepulveda.apirestsistemahotel.security.dtos.JwtDto;
import com.angelsepulveda.apirestsistemahotel.security.dtos.UserLoginDto;

public interface AuthService {

    public JwtDto login(UserLoginDto dto);
}
