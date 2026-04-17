package com.auth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {


    public static final String SECRET_KEY = "ASHHDFHSOIUEUBDIFBUIEWGFVSDVFIWWEE487536DGKFHGHDSGFHKSDGFUEFUEVCUKEUFUDVCVDHSVHSDVHF";

    public String generateToken(String username){
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", "satish@gmail.com");

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5))
                .setClaims(claims)
                .signWith(getKey())
                .compact();
    }

    private Key getKey() {
        byte[] bytes = Base64.getDecoder().decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(bytes);
    }

    private Claims getClaims(String token){
        return Jwts.parser().verifyWith((SecretKey) getKey())
                .build().parseSignedClaims(token)
                .getPayload();
    }

    public Date extractExpiration(String token){
        return getClaims(token).getExpiration();
    }
}