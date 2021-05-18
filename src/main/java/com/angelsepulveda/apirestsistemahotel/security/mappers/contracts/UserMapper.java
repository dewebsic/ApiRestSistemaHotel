package com.angelsepulveda.apirestsistemahotel.security.mappers.contracts;

import com.angelsepulveda.apirestsistemahotel.security.dtos.NewUserDto;
import com.angelsepulveda.apirestsistemahotel.security.models.User;

public interface UserMapper {

    public User fromDto(NewUserDto dto);
}
