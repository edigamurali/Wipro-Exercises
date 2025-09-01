package com.wipro.order.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JWTAuthorizationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        
        String path = request.getRequestURI();
        String method = request.getMethod();
        
        System.out.println("=== Order Service Filter ===");
        System.out.println("Method: " + method + ", Path: " + path);

        // Skip authentication for Swagger endpoints
        if (path.startsWith("/swagger-ui") || path.startsWith("/v3/api-docs")) {
            filterChain.doFilter(request, response);
            return;
        }

        // First priority: Check for Gateway headers (X-User and X-Roles)
        String userHeader = request.getHeader("X-User");
        String rolesHeader = request.getHeader("X-Roles");
        String userIdHeader = request.getHeader("X-User-Id");
        
        if (userHeader != null && !userHeader.isEmpty() && rolesHeader != null && !rolesHeader.isEmpty()) {
            System.out.println("Using Gateway headers - User: " + userHeader + ", Roles: " + rolesHeader);
            
            List<SimpleGrantedAuthority> authorities = Arrays.stream(rolesHeader.split(","))
                    .map(String::trim)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(
                            new User(userHeader, "", authorities),
                            null,
                            authorities
                    );
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(auth);
            System.out.println("Authentication set from Gateway headers");
            
            filterChain.doFilter(request, response);
            return;
        }

        // Second priority: Check for direct JWT token
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                if (!jwtUtil.isTokenExpired(token)) {
                    String username = jwtUtil.extractUsername(token);
                    List<String> roles = jwtUtil.extractRoles(token);

                    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                        var authorities = roles.stream()
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList());

                        UsernamePasswordAuthenticationToken auth =
                                new UsernamePasswordAuthenticationToken(
                                        new User(username, "", authorities),
                                        null,
                                        authorities
                                );
                        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(auth);
                        System.out.println("JWT authentication successful for user: " + username + " with roles: " + roles);
                    }
                } else {
                    System.out.println("JWT token expired");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
            } catch (Exception e) {
                System.out.println("JWT validation failed: " + e.getMessage());
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        } else {
            System.out.println("No Authorization header found");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        
        System.out.println("Proceeding to security chain with authenticated user");
        filterChain.doFilter(request, response);
    }
}