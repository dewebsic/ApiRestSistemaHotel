package com.angelsepulveda.apirestsistemahotel.security.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDto{

    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String password;
    private String email;
    private Boolean state;
    private Set<String> roles = new HashSet<>();
}
