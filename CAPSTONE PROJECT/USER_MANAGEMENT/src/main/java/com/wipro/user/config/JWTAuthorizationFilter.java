package com.wipro.user.config;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wipro.user.util.AppConstant;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private static final String HEADER = "Authorization";
    private static final String PREFIX  = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            String uri = request.getRequestURI();

            // Public endpoints
            if ("OPTIONS".equalsIgnoreCase(request.getMethod())
                || uri.contains("/user/login")
                || uri.contains("/user/register")
                || uri.contains("/user/public")) {
                chain.doFilter(request, response);
                return;
            }

            // JWT validation for protected endpoints
            if (hasJWT(request)) {
                Claims claims = validateToken(request);
                List<String> roles = claims.get("roles", List.class);
                if (roles != null) {
                    var authorities = roles.stream()
                                           .map(SimpleGrantedAuthority::new)
                                           .collect(Collectors.toList());

                    UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(claims.getSubject(), null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(auth);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
            chain.doFilter(request, response);
        } catch (JwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid or expired token");
        }
    }

    private boolean hasJWT(HttpServletRequest request) {
        String authHeader = request.getHeader(HEADER);
        return authHeader != null && authHeader.startsWith(PREFIX);
    }

    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(java.util.Base64.getDecoder().decode(AppConstant.SECRET)))
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }
}
