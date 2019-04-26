/**
 * 
 */
package com.businessdecision.rest.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration.
 * @author bernard.adanlessossi
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
}
