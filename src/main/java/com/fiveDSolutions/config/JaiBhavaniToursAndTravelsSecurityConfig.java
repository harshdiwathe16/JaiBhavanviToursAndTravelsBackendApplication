package com.fiveDSolutions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

/**
 * File Name: JaiBhavaniToursAndTravelsSecurityConfig.java
 * Entity: JaiBhavaniToursAndTravelsSecurityConfig
 * Package: com.fiveDSolutions.JaiBhavaniToursAndTravels.config
 * Author: pranayramteke
 * Date: 28/08/25
 * Description:
 */

@Configuration
public class JaiBhavaniToursAndTravelsSecurityConfig
{
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(requests)->requests.anyRequest().permitAll()
		);
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		return (SecurityFilterChain)http.build();
	}
	
	///  Creating Password Encoder At Framework Level
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
	///  Adding Additional Password Checker Layer
	@Bean
	CompromisedPasswordChecker passwordChecker()
	{
		return new HaveIBeenPwnedRestApiPasswordChecker();
	}
	
}
