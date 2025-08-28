package com.fiveDSolutions.dto;

import com.fiveDSolutions.model.BaseEntity;
import com.fiveDSolutions.model.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * File Name: ApplicationUsers.java
 * Entity: ApplicationUsers
 * Package: com.fiveDSolutions.JaiBhavaniToursAndTravels.model
 * Author: pranayramteke
 * Date: 28/08/25
 * Description:
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApplicationUsersDto extends BaseEntity
{
	private Long applicationUserId;
	
	@Email
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String mobileNumber;
	
	private Roles role;

	public ApplicationUsersDto(Long applicationUserId, String userName, String email, String mobileNumber, Roles role) {
	}
}
