package com.spring.config;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	

	@Bean
	public PasswordEncoder PwdEncoder() {
		
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();
	http.cors().disable();
	// "/","/index"는 모든 사용자에게 허용, 그 외 요청은 인증이 필요
	http.authorizeRequests().antMatchers("/","/index","/user/**").permitAll()
	
	//다른페이지는 인증 필요
	.anyRequest().authenticated()
	.and()
	//폼 인증 사용
	.formLogin()
	.loginPage("/") //스프링시큐리티에서 제공하는 로그인페이지를 사용하지 않고 만든 로그인페이지사용
	.loginProcessingUrl("/") //실제 로그인 처리할 페이지
	.defaultSuccessUrl("/feed"); //로그인 후 이동할 페이지
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {

		web.ignoring().antMatchers("/css/**","/images/**","/js/**");
	
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(PwdEncoder());
	}
	
	
	
}
