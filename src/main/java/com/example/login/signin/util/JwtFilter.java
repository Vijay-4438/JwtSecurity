package com.example.login.signin.util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String path = request.getServletPath();

        // Skip JWT check for public endpoints
        if (path.startsWith("/api/users/register") ||
            path.startsWith("/api/users/login") ||
            path.startsWith("/api/users/verify-otp") ||
            path.startsWith("/api/users/forgot-password") ||
            path.startsWith("/api/users/reset-password")||path.startsWith("/api/users/all")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if (jwtUtil.validateToken(token)) {
                filterChain.doFilter(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT token");
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing Authorization header");
        return;
        }
        filterChain.doFilter(request, response);
    }
}
    

   