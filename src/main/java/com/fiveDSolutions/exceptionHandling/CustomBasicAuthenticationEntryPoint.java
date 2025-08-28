package com.fiveDSolutions.exceptionHandling;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * File Name: CustomBasicAuthenticationEntryPoint.java
 * Entity: CustomBasicAuthenticationEntryPoint
 * Package: com.fiveDSolutions.JaiBhavaniToursAndTravels.exceptionHandling
 * Author: pranayramteke
 * Date: 28/08/25
 * Description:
 */

public class CustomBasicAuthenticationEntryPoint  implements AuthenticationEntryPoint
{
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException
	{
		// Populate dynamic values
		LocalDateTime currentTimeStamp = LocalDateTime.now();
		
		String message = (null != authException && null != authException.getMessage()) ? authException.getMessage() : "UnAuthorized";
		String path    = request.getRequestURI();
		
		response.setHeader("5dSolutions-reason","Authentication Failed");
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType("application/json;charset=UTF-8");
		
		String jsonResponse =
				String.format("{\"timestamp\": \"%s\", \"status\": %d, \"error\": \"%s\", \"message\": \"%s\", \"path\": \"%s\"}",
						currentTimeStamp, HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase(),
						message, path);
		
		response.getWriter().write(jsonResponse);
	}
}
