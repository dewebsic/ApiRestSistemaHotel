package com.angelsepulveda.apirestsistemahotel.security.services;

import com.angelsepulveda.apirestsistemahotel.exceptions.ModelNotFoundException;
import com.angelsepulveda.apirestsistemahotel.security.models.User;
import com.angelsepulveda.apirestsistemahotel.security.repositories.UserRepository;
import com.angelsepulveda.apirestsistemahotel.security.services.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByName(String name) {
        return this.userRepository.findByName(name);
    }

    @Override
    public boolean existsByNameUser(String name) {
        return this.userRepository.existsByName(name);
    }

    @Override
    public boolean existsByEmailUser(String email){
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public User save(User dto) throws Exception{
        try{
           return this.userRepository.save(dto);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
