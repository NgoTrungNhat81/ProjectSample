package com.vti.login;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsUtils;

import com.vti.service.JWTTokenService;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	
    public JWTAuthenticationFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    		throws AuthenticationException, IOException, ServletException {
    	
//    	if (CorsUtils.isPreFlightRequest(request)) {
//            response.setStatus(HttpServletResponse.SC_OK);
//            return new Authentication() ; //whatever your token implementation class is - return an instance of it
//    	}
        
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                		request.getParameter("username"),
                		request.getParameter("password"),
                        Collections.emptyList()
                )
        );
    }
    
    

    @Override
    protected void successfulAuthentication(
    		HttpServletRequest request, 
    		HttpServletResponse response, 
    		FilterChain chain, 
    		Authentication authResult) throws IOException, ServletException {
        JWTTokenService.addJWTTokenToHeader(response,authResult.getName(),authResult.getAuthorities().toArray()[0].toString());
        
    }
}
