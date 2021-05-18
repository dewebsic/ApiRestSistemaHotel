package com.angelsepulveda.apirestsistemahotel.security.mappers;

import com.angelsepulveda.apirestsistemahotel.security.dtos.NewUserDto;
import com.angelsepulveda.apirestsistemahotel.security.mappers.contracts.UserMapper;
import com.angelsepulveda.apirestsistemahotel.security.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User fromDto(NewUserDto dto) {
        return new User(dto.getName(),
                dto.getLastName(),
                dto.getAddress(),dto.getPhoneNumber(),
                dto.getEmail(),
                passwordEncoder.encode(dto.getPassword()),
                dto.getState());
    }
}
