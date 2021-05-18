package com.angelsepulveda.apirestsistemahotel.security.services.contracts;

import com.angelsepulveda.apirestsistemahotel.security.dtos.NewUserDto;
import com.angelsepulveda.apirestsistemahotel.security.models.User;

import java.util.Optional;

public interface UserService {

    public Optional<User> findByEmail(String email);
    public boolean existsByNameUser(String name);
    public boolean existsByEmailUser(String email);
    User save(NewUserDto dto) throws Exception;

}
