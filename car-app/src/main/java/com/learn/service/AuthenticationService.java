package com.learn.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import static java.util.Collections.emptyList;


public class AuthenticationService {
	
	// 1 day in milliseconds
	static final long EXPIRATIONTIME = 864_000_00;
	static final String SIGINGKEY = "SecretKey";
	static final String PREFIX = "Bearer";
	
	// Add token to authorization header
	static public void addToken(HttpServletResponse res, String username) {
		String JwtToken = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SIGINGKEY)
				.compact();
		res.addHeader("Authorization",  PREFIX + " " + JwtToken);
		res.addHeader("Access-Control-Expose-Headers", "Authorization");
	}
	
	// Get token from Authorization header
	static public Authentication getAuthentication(HttpServletRequest req) {
		String token = req.getHeader("Authorization");
		if(token != null) {
			String user = Jwts.parser()
					.setSigningKey(SIGINGKEY)
					.parseClaimsJws(token.replace(PREFIX, ""))
					.getBody()
					.getSubject();
			if(user != null) 
				return new UsernamePasswordAuthenticationToken(user, null, emptyList());
			
			//return null;
		}
		return null;
	}

}
