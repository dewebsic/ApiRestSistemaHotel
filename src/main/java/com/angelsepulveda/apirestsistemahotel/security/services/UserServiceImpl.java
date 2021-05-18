package com.angelsepulveda.apirestsistemahotel.security.services;

import com.angelsepulveda.apirestsistemahotel.exceptions.ModelNotFoundException;
import com.angelsepulveda.apirestsistemahotel.security.dtos.NewUserDto;
import com.angelsepulveda.apirestsistemahotel.security.enums.RoleName;
import com.angelsepulveda.apirestsistemahotel.security.mappers.contracts.UserMapper;
import com.angelsepulveda.apirestsistemahotel.security.models.Role;
import com.angelsepulveda.apirestsistemahotel.security.models.User;
import com.angelsepulveda.apirestsistemahotel.security.repositories.UserRepository;
import com.angelsepulveda.apirestsistemahotel.security.services.contracts.RoleService;
import com.angelsepulveda.apirestsistemahotel.security.services.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserMapper userMapper;

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
    public User save(NewUserDto dto) throws Exception{
        try{

            //convertimos a user
            User user = this.userMapper.fromDto(dto);

            Set<Role> roles = new HashSet<>();

            roles.add(roleService.findByRoleName(RoleName.ROLE_USER).get());

            if(dto.getRoles().contains("admin")){
                roles.add(roleService.findByRoleName(RoleName.ROLE_ADMIN).get());
            }
            user.setRoles(roles);

            return this.userRepository.save(user);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
