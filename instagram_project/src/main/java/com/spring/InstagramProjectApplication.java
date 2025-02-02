package com.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@MapperScan(basePackages = {"com.spring.mapper"})
public class InstagramProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstagramProjectApplication.class, args);
	}

}
