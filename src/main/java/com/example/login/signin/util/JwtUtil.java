package com.example.login.signin.util;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	

	    // Minimum 256-bit secret for HS256
	    private static final String SECRET = "my-super-secret-key-that-is-at-least-32-bytes!";
	    private static final long EXPIRATION_MS = 1000 * 60 * 60; // 1 hour

	    private  Key key;

	    public JwtUtil() {
	        // Create secure key from the secret
	        this.key = Keys.hmacShaKeyFor(SECRET.getBytes());
	    }

	    // Generate JWT with email as subject
	    public String generateToken(String email) {
	        return Jwts.builder()
	                .setSubject(email)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
	                .signWith(key, SignatureAlgorithm.HS256)
	                .compact();
	    }

	    // Extract email (subject) from token
	    public String extractEmail(String token) {
	        return Jwts.parserBuilder()
	                .setSigningKey(key)
	                .build()
	                .parseClaimsJws(token)
	                .getBody()
	                .getSubject();
	    }

	    // Validate token
	    public boolean validateToken(String token) {
	        try {
	            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
	            return true;
	        } catch (JwtException | IllegalArgumentException e) {
	            return false;
	        }
	    }
	}