package com.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	

	@Value("${spring.servlet.multipart.location}")
	private String fileRealPath;
	
	//static 외부에 있는 폴더 불러오기
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);

		registry.addResourceHandler("/upload/**").addResourceLocations("file:///" + fileRealPath).setCachePeriod(3600)
				.resourceChain(true).addResolver(new PathResourceResolver());
	}
	
	
}
