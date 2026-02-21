package com.saugat.bootcamp.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class JwtUtils {
    private static final String SECRET = "CHANGE_ME_TO_A_LONG_RANDOM_SECRET_AT_LEAST_32_CHARS_LONG_123456";

    public static String extractSubject(String token) {
        try{
            Claims claims = Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return claims.getSubject();
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> extractRole(String token){
        try{
            Claims claims = Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return (List<String>)claims.get("roles");
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
