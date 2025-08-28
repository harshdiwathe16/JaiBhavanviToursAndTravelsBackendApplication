package com.fiveDSolutions.service;

import com.fiveDSolutions.dto.ApplicationUsersDto;

import java.util.Set;

/**
 * File Name: IApplicationUserService.java
 * Entity: IApplicationUserService
 * Package: com.fiveDSolutions.JaiBhavaniToursAndTravels.service
 * Author: pranayramteke
 * Date: 28/08/25
 * Description:
 */

public interface IApplicationUserService
{
	public abstract ApplicationUsersDto createApplicationUser(ApplicationUsersDto applicationUsersDto);
	
	public abstract ApplicationUsersDto getApplicationUserById(Long applicatioUserId);
	
	public abstract Set<ApplicationUsersDto> getAllApplicationUsers();
	
	public abstract ApplicationUsersDto partialUpdateApplicationUserById(Long applicatioUserId);
	
	public abstract ApplicationUsersDto updateApplicationUserById(Long applicatioUserId);
	
	public abstract ApplicationUsersDto deleteApplicationUserById(Long applicatioUserId);
}
