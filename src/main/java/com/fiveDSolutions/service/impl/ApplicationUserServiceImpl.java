package com.fiveDSolutions.service.impl;

import com.fiveDSolutions.dto.ApplicationUsersDto;
import com.fiveDSolutions.repository.ApplicationUserRepository;
import com.fiveDSolutions.service.IApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * File Name: ApplicationUserServiceImpl.java
 * Entity: ApplicationUserServiceImpl
 * Package: com.fiveDSolutions.JaiBhavaniToursAndTravels.service.impl
 * Author: pranayramteke
 * Date: 28/08/25
 * Description:
 */

@Service
public class ApplicationUserServiceImpl implements IApplicationUserService
{
	@Autowired
	ApplicationUserRepository applicationUserRepository;
	
	@Override
	public ApplicationUsersDto createApplicationUser(ApplicationUsersDto applicationUsersDto) {
		return null;
	}
	
	@Override
	public ApplicationUsersDto getApplicationUserById(Long applicatioUserId) {
		return null;
	}
	
	@Override
	public Set<ApplicationUsersDto> getAllApplicationUsers() {
		return Set.of();
	}
	
	@Override
	public ApplicationUsersDto partialUpdateApplicationUserById(Long applicatioUserId) {
		return null;
	}
	
	@Override
	public ApplicationUsersDto updateApplicationUserById(Long applicatioUserId) {
		return null;
	}
	
	@Override
	public ApplicationUsersDto deleteApplicationUserById(Long applicatioUserId) {
		return null;
	}
}
