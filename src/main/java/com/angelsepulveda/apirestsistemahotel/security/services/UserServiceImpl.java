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
import com.angelsepulveda.apirestsistemahotel.security.validators.contracts.UserValidator;
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

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserMapper userMapper;
    private final UserValidator userValidator;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService,
                           UserMapper userMapper, UserValidator userValidator) {

        this.userRepository = userRepository;
        this.roleService = roleService;
        this.userMapper = userMapper;
        this.userValidator = userValidator;
    }


    @Override
    public Optional<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
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

            //validamos el usuario
            this.userValidator.validate(user);

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
