package com.example.sesion9.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
    
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiDetails())
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot API REST",
            "Library Api Rest Docs",
            "1.0", 
            "http://www.google.com", 
            new Contact("Oscar Talero", "http://www.google.com", "talero@gmail.com"),
            "MIT", 
            "http://www.google.com", 
            Collections.emptyList());
    }
}
