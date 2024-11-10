package com.example.demo.util;



import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtToken {
    private String SECRET = "your-secret-key"; // Use a secure key
    private final long EXPIRATION_TIME = 900_000; // 15 minutes

    private String generateSecretKey(){
        byte[] randomBytes = new byte[32]; // 256 bits
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(randomBytes);
        
        // Encode the key to Base64 for easy storage
        return Base64.getEncoder().encodeToString(randomBytes);

    }
    public String generateToken(String username) {
        SECRET = generateSecretKey();
        Map<String, Object> claims = getClaims(username);
        String a="";
        try{
                a=Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 30))
                .and()
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .compact();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

                return a;
                    }
            private Map<String, Object> getClaims(String username) {
                Map<String, Object> claims = new HashMap<>();
                claims.put("username", username);
                claims.put("role", "STUDENT"); // default role
                return claims;
}
        }