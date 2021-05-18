package com.angelsepulveda.apirestsistemahotel.security.services.contracts;

import com.angelsepulveda.apirestsistemahotel.security.models.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByName(String name);
    boolean existsByNameUser(String name);
    boolean existsByEmailUser(String email);
    User save(User dto) throws Exception;

}
