package com.angelsepulveda.apirestsistemahotel.security.services;

import com.angelsepulveda.apirestsistemahotel.security.dtos.JwtDto;
import com.angelsepulveda.apirestsistemahotel.security.dtos.UserLoginDto;
import com.angelsepulveda.apirestsistemahotel.security.jwt.JwtProvider;
import com.angelsepulveda.apirestsistemahotel.security.services.contracts.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @Override
    public JwtDto login(UserLoginDto dto) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                dto.getEmail(),
                                dto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        return new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
    }
}
