package com.angelsepulveda.apirestsistemahotel.security.services;

import com.angelsepulveda.apirestsistemahotel.security.models.User;
import com.angelsepulveda.apirestsistemahotel.security.models.UserMain;
import com.angelsepulveda.apirestsistemahotel.security.services.contracts.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user = this.userService.findByName(name).get();

        return UserMain.build(user);
    }
}
