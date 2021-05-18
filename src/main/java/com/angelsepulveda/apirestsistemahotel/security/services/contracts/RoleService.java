package com.angelsepulveda.apirestsistemahotel.security.services.contracts;

import com.angelsepulveda.apirestsistemahotel.security.enums.RoleName;
import com.angelsepulveda.apirestsistemahotel.security.models.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByRoleName(RoleName roleName) throws Exception;
}
