package com.cg.onlineexamportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("package com.cg.onlineexamportal.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build().apiInfo(apiEndPointsInfo());			
	}

	private ApiInfo apiEndPointsInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder()
				.title("Spring Boot REST API with ")
				.description("")
				.contact(new Contact("Capg", "Capg", "Capg"))
				.license("")
				.licenseUrl("")
				.version("")
				.build();
	}
}
