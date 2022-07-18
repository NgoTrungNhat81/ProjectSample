package com.vti.service;

import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

public class JWTTokenService {
	
    private static final long EXPIRATION_TIME = 864000000; // 10 days
    private static final String SECRET = "123456";
    private static final String PREFIX_TOKEN = "Bearer";
    private static final String AUTHORIZATION = "Authorization";

    public static void addJWTTokenToHeader(HttpServletResponse response, String username,String role) {
        String JWT = Jwts.builder()
                .setSubject(username)
                .claim(username, role)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact() 	;
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader(AUTHORIZATION, PREFIX_TOKEN + " " + JWT);
       
    }

    public static Authentication parseTokenToUserInformation(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION);
        
        if (token == null || token.startsWith("Basic")) {
        	return null;
        }
        
        // parse the token
        String username = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace(PREFIX_TOKEN, ""))
                .getBody()
                .getSubject()
                ;
        
        final JwtParser jwtParser = Jwts.parser().setSigningKey(SECRET);
        
        final Jws claimsJws = jwtParser.parseClaimsJws(token.replace(PREFIX_TOKEN, ""));
        final Claims claims = (Claims) claimsJws.getBody();
        
        final Collection authorities =
                Arrays.stream(claims.get(username).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return username != null ?
                new UsernamePasswordAuthenticationToken(username, null, authorities) :
                null;
    }
}