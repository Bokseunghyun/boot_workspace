package com.spring.Filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.filter.CompositeFilter;

import com.spring.Handler.OAuth2SuccessHandler;

@EnableWebSecurity
@EnableOAuth2Client
public class OAuth2Filter {
	
	@Autowired
	OAuth2ClientContext oauth2clientcontext;
	
	@Bean
	@ConfigurationProperties("facebook.client")
	OAuth2ProtectedResourceDetails facebookclient() {
		return new AuthorizationCodeResourceDetails();
	}
	
	
	@Bean
	@ConfigurationProperties("facebook.resource")
	ResourceServerProperties facebookResource() {
		return new ResourceServerProperties();
	}
	
	
	public Filter ssoFilter() {
		CompositeFilter filter = new CompositeFilter();
		List<Filter> filterList = new ArrayList<>();
		
		OAuth2ClientAuthenticationProcessingFilter facebookFilter = new OAuth2ClientAuthenticationProcessingFilter("/login/facebook");
		
		filterList.add(ssoFilter("/login/facebook", facebookFilter));
		filter.setFilters(filterList);
		return filter;
	}
	
	public Filter ssoFilter(String path, OAuth2ClientAuthenticationProcessingFilter Filter) {
		ResourceServerProperties resource = null;
		OAuth2ProtectedResourceDetails client = null;

		if(path.equals("/login/facebook")) {
			resource = facebookResource();
			client = facebookclient();
		}
		
		OAuth2RestTemplate Template = new OAuth2RestTemplate(client, oauth2clientcontext);
		Filter.setRestTemplate(Template);
		Filter.setTokenServices(
				new UserInfoTokenServices(resource.getUserInfoUri(), client.getClientId()));
		Filter.setAuthenticationSuccessHandler(new OAuth2SuccessHandler());
		
		return Filter;
	}
	
	@Bean
	public FilterRegistrationBean<OAuth2ClientContextFilter> oauth2ClientFilterRegistration(
	    OAuth2ClientContextFilter filter) {
	  FilterRegistrationBean<OAuth2ClientContextFilter> registration = new FilterRegistrationBean<>();
	  registration.setFilter(filter);
	  //다른필터보다 우선순위를 높히기 위해 -100을 줌
	  registration.setOrder(-100);
	  return registration;
	}
}
