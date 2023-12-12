package com.example.authentication.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService UseruserDetailsService(PasswordEncoder encoder) {
	    UserBuilder users = User.builder();
	    UserDetails admin = users.username("rohith")
	            .password(encoder.encode("password"))
	            .roles("ADMIN")
	            .build();
	    UserDetails user = users.username("bunny")
	            .password(encoder.encode("password"))
	            .roles("USER")
	            .build();

	    System.out.println("Created users: " + admin + ", " + user);

	    return new InMemoryUserDetailsManager(admin, user);
	}

	

	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.authorizeRequests(authorizeRequests ->
	            authorizeRequests
	                .requestMatchers("/api/welcome").permitAll()  // Allow all for /api/welcome
	                //.requestMatchers("/api/product/**").authenticated() // Require authentication for /product/**
	                .requestMatchers("/api/product/**").authenticated()
	        ).httpBasic(Customizer.withDefaults())
				.build();
	}
}







