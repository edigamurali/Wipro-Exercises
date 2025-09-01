package com.wipro.gateway.filter;

import java.security.Key;
import java.util.Base64;
import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import reactor.core.publisher.Mono;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JwtGatewayFilter implements GlobalFilter {

    private static final String SECRET_BASE64 = "49y3Rvz4iF6hOZht7RszM8+A6BNs++KIabZDGt4OMbsTkyYqifHnDotf6X47nuOryU8IYJ3x/ooXZX5EN642KQ==";
    private static final Key SIGNING_KEY = Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_BASE64));

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        String method = request.getMethod().name();

        System.out.println("=== Gateway Filter ===");
        System.out.println("Method: " + method + ", Path: " + path);

        // Allow public endpoints without authentication
        if (isPublicEndpoint(path, method)) {
            System.out.println("Public endpoint - allowing request");
            return chain.filter(exchange);
        }

        // Check for Authorization header
        String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("Missing or invalid Authorization header");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = authHeader.substring(7);
        try {
            Claims claims = Jwts.parserBuilder()
                                .setSigningKey(SIGNING_KEY)
                                .build()
                                .parseClaimsJws(token)
                                .getBody();

            String username = claims.getSubject();
            List<String> roles = claims.get("roles", List.class);
            String userId = claims.get("userId", String.class);

            System.out.println("Token valid - User: " + username + ", Roles: " + roles + ", UserId: " + userId);

            // Add user info to headers for downstream services
            ServerHttpRequest mutatedRequest = request.mutate()
                    .header("X-User", username != null ? username : "")
                    .header("X-Roles", roles != null ? String.join(",", roles) : "")
                    .header("X-User-Id", userId != null ? userId : "")
                    .header("X-User-Name", claims.get("name", String.class) != null ? claims.get("name", String.class) : "")
                    .build();

            return chain.filter(exchange.mutate().request(mutatedRequest).build());

        } catch (JwtException e) {
            System.out.println("Invalid JWT token: " + e.getMessage());
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
    }

    private boolean isPublicEndpoint(String path, String method) {
        // Only these specific endpoints are public
        return (path.equals("/user/register") && method.equals("POST")) ||
               (path.equals("/user/login") && method.equals("POST")) ||
               (path.equals("/user/logout") && method.equals("POST")) ||
               path.startsWith("/user/public") ||
               path.startsWith("/swagger-ui") ||
               path.startsWith("/v3/api-docs");
    }
}
