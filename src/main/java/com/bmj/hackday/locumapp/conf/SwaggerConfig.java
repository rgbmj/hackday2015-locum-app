package com.bmj.hackday.locumapp.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
@Profile("default")
public class SwaggerConfig {
	
	private SpringSwaggerConfig springSwaggerConfig;
	
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig){
		this.springSwaggerConfig = springSwaggerConfig;
	}
	
	@Bean
	public SwaggerSpringMvcPlugin customImplementation(){
		return initPlugin()
				.apiInfo(apiInfo())
				.includePatterns("/.*");
	}

	private SwaggerSpringMvcPlugin initPlugin() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig);
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"LocumServices API", 
				"API for LocumServices", 
				"BMJ Terms of Service", 
				"hackday@bmj.com", 
				"BMJ Technology License type", 
				"BMJ License URL");
		
		return apiInfo;
	}

}
