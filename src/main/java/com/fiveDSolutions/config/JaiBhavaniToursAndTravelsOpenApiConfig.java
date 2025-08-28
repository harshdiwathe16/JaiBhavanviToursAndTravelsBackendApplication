package com.fiveDSolutions.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
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
public class JaiBhavaniToursAndTravelsOpenApiConfig
{
	@Bean
	public OpenAPI customOpenAPI() {
		OpenAPI openAPI = new OpenAPI();
		
		openAPI.info(
						new Info().title("Student Self Reflection API")
								.version("1.0")
								.description("API documentation for S2P SSR backend")
				).addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
				.components(new Components().addSecuritySchemes("bearerAuth",new SecurityScheme()
						.type(SecurityScheme.Type.HTTP)
						.scheme("bearer")
						.bearerFormat("JWT")
				));
		
		
		return openAPI;
	}
}
