package com.wipro.order.config;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wipro.order.util.AppConstant;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    private final SecretKey secretKey;

    public JwtUtil() {
        byte[] decodedKey = Base64.getDecoder().decode(AppConstant.SECRET);
        this.secretKey = Keys.hmacShaKeyFor(decodedKey);
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public List<String> extractRoles(String token) {
        return extractAllClaims(token).get("roles", List.class);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}