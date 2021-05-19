package com.angelsepulveda.apirestsistemahotel.utils;

import com.angelsepulveda.apirestsistemahotel.security.enums.RoleName;
import com.angelsepulveda.apirestsistemahotel.security.models.Role;
import com.angelsepulveda.apirestsistemahotel.security.services.contracts.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRole implements CommandLineRunner {

    private final RoleService roleService;

    public CreateRole(RoleService roleService)
    {
        this.roleService = roleService;
    }
    @Override
    public void run(String... args) throws Exception {

        if(!this.roleService.existsByRoleName(RoleName.ROLE_ADMIN)){

            Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
            Role roleUser = new Role(RoleName.ROLE_USER);

            this.roleService.save(roleAdmin);
            this.roleService.save(roleUser);

        }
    }
}
