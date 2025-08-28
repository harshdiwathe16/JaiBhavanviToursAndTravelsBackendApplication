package com.fiveDSolutions.config;

import com.fiveDSolutions.model.ApplicationUsers;
import com.fiveDSolutions.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * File Name: JaiBhavaniToursAndTravelsSecurityConfig.java
 * Entity: JaiBhavaniToursAndTravelsSecurityConfig
 * Package: com.fiveDSolutions.JaiBhavaniToursAndTravels.config
 * Author: pranayramteke
 * Date: 28/08/25
 * Description:
 */

@Component
@RequiredArgsConstructor
public class JaiBhavaniToursAndTravelsUserDetailsService implements UserDetailsService
{
	@Autowired
	private final ApplicationUserRepository applicationUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		ApplicationUsers applicationUser = fetchUserByEmail(email);
		
		// Exception Handling
		if(null == applicationUser)
		{
			throw new UsernameNotFoundException("User Detail Not Found For The User : " + email);
		}


		List<GrantedAuthority> authorityList = List.of(new SimpleGrantedAuthority(applicationUser.getRole().getRoleName()));
		List<GrantedAuthority> authorityList1 = List.of(new SimpleGrantedAuthority(applicationUser.getRole().getName()));
		
		User userDetails = new User(applicationUser.getUserName(),applicationUser.getPassword(),authorityList);
		
		return userDetails;
		
	}
	
	
	private ApplicationUsers fetchUserByEmail(String email)
	{
		ApplicationUsers applicationUser = null;
		
		if(null == applicationUser)
		{
			applicationUser = applicationUserRepository.findByEmail(email).orElse(null);
		}
		
//		// Business Logic To Fetch Teacher
//		if(null == applicationUser) {
//			applicationUser = teacherRepository.findByEmail(email).orElse(null);
//		}
//
//		// Business Logic To Fetch Student
//		if(null == applicationUser)
//		{
//			applicationUser = studentRepository.findByEmail(email).orElse(null);
//		}
//
		return applicationUser;
	}
}
