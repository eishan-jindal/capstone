package com.xen.cap.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
		.inMemoryAuthentication()
			.withUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER"));
		
		
//		auth.inMemoryAuthentication()
//			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//			.withUser(users.username("mary").password("test123").roles("MANAGER"))
//			.withUser(users.username("susan").password("test123").roles("ADMIN"));
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http
		.authorizeRequests()
			.antMatchers("/index").permitAll()
			.antMatchers("/user/**").hasRole("USER")
			.and()
		.formLogin().loginPage("/login").failureUrl("/login-error");
		
		
		
//		http.authorizeRequests().anyRequest().authenticated()
//		.and()
//		.formLogin()
//		.loginPage("/showLoginPage")
//		.loginProcessingUrl("authenticateTheUser")
//		.permitAll();
	}
	
	

}
