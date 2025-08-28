package com.fiveDSolutions.service.impl;

import com.fiveDSolutions.dto.RolesDto;
import com.fiveDSolutions.repository.RolesRepository;
import com.fiveDSolutions.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * File Name: RolesServiceImpl.java 
 * Entity: RolesServiceImpl
 * Package: com.fiveDSolutions.JaiBhavaniToursAndTravels.service.impl
 * Author: pranayramteke
 * Date: 28/08/25
 * Description: 
 */
 
 public class RolesServiceImpl implements IRolesService {
	 
	 @Autowired
	RolesRepository rolesRepository;
	
	@Override
	public RolesDto getRolesByName(String rolesName) {
		return null;
	}
}
