package com.angelsepulveda.apirestsistemahotel.security.services.contracts;

import com.angelsepulveda.apirestsistemahotel.security.enums.RoleName;
import com.angelsepulveda.apirestsistemahotel.security.models.Role;

import java.util.Optional;

public interface RoleService {

    public Optional<Role> findByRoleName(RoleName roleName) throws Exception;
    public void save(Role role);
}
