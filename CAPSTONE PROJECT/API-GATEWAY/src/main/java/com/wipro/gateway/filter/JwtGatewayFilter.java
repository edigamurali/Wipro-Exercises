package com.wipro.gateway.filter;

import java.security.Key;
import java.util.Base64;
import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
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

    // Keep same secret as other services
    private static final String SECRET_BASE64 = "49y3Rvz4iF6hOZht7RszM8+A6BNs++KIabZDGt4OMbsTkyYqifHnDotf6X47nuOryU8IYJ3x/ooXZX5EN642KQ==";
    private static final Key SIGNING_KEY = Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_BASE64));

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();

        // Public endpoints (gateway-level): allow without Authorization
        if (path.startsWith("/user/register") || path.startsWith("/user/login") || path.startsWith("/user/public") || path.startsWith("/products/public")) {
            return chain.filter(exchange);
        }

        String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // Reject if trying to access protected routes without token
            exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.FORBIDDEN);
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

            // propagate user info downstream as headers (optional but useful)
            ServerHttpRequest mutated = request.mutate()
                    .header("X-User", username != null ? username : "")
                    .header("X-Roles", roles != null ? String.join(",", roles) : "")
                    .build();

            return chain.filter(exchange.mutate().request(mutated).build());
        } catch (JwtException e) {
            exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }
    }
}
