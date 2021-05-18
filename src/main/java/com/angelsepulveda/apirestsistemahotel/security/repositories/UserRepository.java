package com.angelsepulveda.apirestsistemahotel.security.repositories;

import com.angelsepulveda.apirestsistemahotel.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByEmail(String email);
    boolean existsByName(String name);
    boolean existsByEmail(String name);
}
