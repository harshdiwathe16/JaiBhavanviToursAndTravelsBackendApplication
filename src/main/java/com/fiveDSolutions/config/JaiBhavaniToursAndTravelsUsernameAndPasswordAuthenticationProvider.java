package com.fiveDSolutions.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


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
public class JaiBhavaniToursAndTravelsUsernameAndPasswordAuthenticationProvider implements AuthenticationProvider
{
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();  // Fetching Email
		String password = authentication.getCredentials().toString(); // Fetching password
		UserDetails userDetails = userDetailsService.loadUserByUsername(email); // loading user by username / email
		
		if(passwordEncoder.matches(password, userDetails.getPassword()))
		{
			return new UsernamePasswordAuthenticationToken(email,password,userDetails.getAuthorities());
		}
		else {
			throw new BadCredentialsException("Invalid Password");
		}
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
