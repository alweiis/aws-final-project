package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer{

	//for window
	// public static final String savePath = "c:/upload/"; 
	
	//for linux
	public static final String savePath = "/usr/upload/"; 
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// for window
		// registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/upload/");
		
		// for linux
		registry.addResourceHandler("/upload/**").addResourceLocations("file:/usr/upload/");
	}

}
	