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
=======
import com.fiveDSolutions.repository.RolesRepository;
import com.fiveDSolutions.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * File Name: RolesServiceImpl.java 
>>>>>>> a355a3e04a80ade329bf2985beafb439894fed98
 * Entity: RolesServiceImpl
 * Package: com.fiveDSolutions.JaiBhavaniToursAndTravels.service.impl
 * Author: pranayramteke
 * Date: 28/08/25
<<<<<<< HEAD
 * Description: Implementation of IRolesService
 */

@Service
public class RolesServiceImpl implements IRolesService {

    @Autowired
    private RolesRepository rolesRepository;

//    @Override
//    public RolesDto findByRoleName(String name) {
//        Optional<Roles> optionalRole = Optional.ofNullable(rolesRepository.findByRoleName(name));
//        if (!optionalRole.isPresent()) {
//            throw new RuntimeException("Role not found with name: " + name);
//        }
//        return mapToDto(optionalRole.get());
//    }
//
//    @Override
//    public RolesDto getRolesByName(String rolesName) {
//        return null;
//    }

    private RolesDto mapToDto(Roles role) {
        RolesDto dto = new RolesDto();
        dto.setRoleId(role.getRoleId());
        dto.setName(role.getRoleName());
        return dto;
    }

}
