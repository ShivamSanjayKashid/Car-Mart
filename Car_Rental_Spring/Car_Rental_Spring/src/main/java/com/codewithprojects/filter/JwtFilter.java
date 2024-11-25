package com.codewithprojects.filter;

import com.codewithprojects.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Claims;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);  // Extract the token (removes "Bearer " prefix)

            if (jwtUtil.validateToken(token)) {
                String username = jwtUtil.extractUsername(token);
                // Add custom logic to set the authenticated user (e.g., fetch user from DB)
                Claims claims = jwtUtil.extractClaims(token);
                // Set authentication details if needed
            }
        }

        filterChain.doFilter(request, response);  // Continue with the next filter
    }
}
