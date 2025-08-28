package com.fiveDSolutions.model;

import jakarta.persistence.*;
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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApplicationUsers extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicationUserId;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String mobileNumber;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Roles role;
}
