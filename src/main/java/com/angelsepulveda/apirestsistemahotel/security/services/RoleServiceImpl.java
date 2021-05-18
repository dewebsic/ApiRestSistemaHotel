package com.angelsepulveda.apirestsistemahotel.security.services;

import com.angelsepulveda.apirestsistemahotel.exceptions.ModelNotFoundException;
import com.angelsepulveda.apirestsistemahotel.security.enums.RoleName;
import com.angelsepulveda.apirestsistemahotel.security.models.Role;
import com.angelsepulveda.apirestsistemahotel.security.repositories.RoleRepository;
import com.angelsepulveda.apirestsistemahotel.security.services.contracts.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findByRoleName(RoleName roleName) throws Exception {

        Optional<Role> role =  this.roleRepository.findByRoleName(roleName);

        if(!role.isPresent()){
            throw new ModelNotFoundException("No existe el role " + roleName);
        }

        return role;

    }
}
