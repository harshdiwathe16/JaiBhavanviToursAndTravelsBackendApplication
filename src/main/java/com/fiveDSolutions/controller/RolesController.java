package com.fiveDSolutions.controller;

import com.fiveDSolutions.dto.RolesDto;
import com.fiveDSolutions.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * File Name: RolesController.java
 * Entity: RolesController
 * Package: com.fiveDSolutions.JaiBhavaniToursAndTravels.controller
 * Author: pranayramteke
 * Date: 28/08/25
 * Description: REST Controller for managing Roles
 */

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private IRolesService rolesService;

//    @GetMapping("/{roleName}")
//    public RolesDto getRoleByName(@PathVariable String roleName) {
//        return rolesService.findByRoleName(roleName);
//    }
}
