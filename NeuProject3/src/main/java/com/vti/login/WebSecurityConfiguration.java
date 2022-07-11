package com.vti.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.vti.service.IUserService;

@Component
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private IUserService service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}
	
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//	    registry.addMapping("/api/**")
//	        .allowedOrigins("http://domain2.com")
//	        .allowedMethods("PUT", "DELETE")
//	        .allowedHeaders("header1", "header2", "header3")
//	        .exposedHeaders("Authorization")
//	        .allowCredentials(false).maxAge(3600);
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/api/v1/login").anonymous()
			.antMatchers("/api/v1/registers").anonymous()
	
			.antMatchers("/api/v1/products1/**").anonymous()
			.antMatchers("/api/v1/categories/**").anonymous()
			.antMatchers("/api/v1/registers/activeUser").anonymous()	
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.csrf().disable()
			
			.addFilterBefore(
					new JWTAuthenticationFilter("/api/v1/login", authenticationManager()), 
					UsernamePasswordAuthenticationFilter.class) 
			.addFilterBefore(
					new JWTAuthorizationFilter(), 
					UsernamePasswordAuthenticationFilter.class)
			 .headers()
	            // the headers you want here. This solved all my CORS problems! 
	            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"))
	            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Methods", "POST, GET"))
	            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Max-Age", "3600"))
	            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Credentials", "true"))
	            .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization"));;;
			
			http.cors()
			;
	

	}
	

	

}