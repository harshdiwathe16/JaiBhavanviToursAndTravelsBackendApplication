package com.fiveDSolutions.service.impl;

import com.fiveDSolutions.dto.RolesDto;
import com.fiveDSolutions.model.Roles;
import com.fiveDSolutions.repository.RolesRepository;
import com.fiveDSolutions.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * File Name: RolesServiceImpl.java
 * Entity: RolesServiceImpl
 * Package: com.fiveDSolutions.JaiBhavaniToursAndTravels.service.impl
 * Author: pranayramteke
 * Date: 28/08/25
 * Description: Implementation of IRolesService
 */

@Service
public class RolesServiceImpl implements IRolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public RolesDto findByRoleName(String name) {
        Optional<Roles> optionalRole = rolesRepository.findByRoleName(name);
        if (!optionalRole.isPresent()) {
            throw new RuntimeException("Role not found with name: " + name);
        }
        return mapToDto(optionalRole.get());
    }

    private RolesDto mapToDto(Roles role) {
        RolesDto dto = new RolesDto();
        dto.setRoleId(role.getRoleId());
        dto.setName(role.getRoleName());
        return dto;
    }
}
