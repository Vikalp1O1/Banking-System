package com.banking.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf().disable()  // Disable CSRF for now (optional)
	        .cors().and()  // Enable CORS
	        .authorizeHttpRequests()
	        .requestMatchers("/api/users/register", "/api/users/login", "/api/users/account/**").permitAll()  // Allow public access to specific endpoints
	        .anyRequest().authenticated();  // All other endpoints require authentication

	    return http.build();
	}

	 
	
}
