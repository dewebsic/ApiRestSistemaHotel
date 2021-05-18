package com.angelsepulveda.apirestsistemahotel.security.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDto {

    private String email;
    private String password;
}
