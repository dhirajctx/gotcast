//package com.example.actorapp.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//
//    private final String secret = "mySuperSecretJWTKey12345"; // Use a long random string
//    private final long expirationMs = 3600000; // 1 hour
//
//    // Generate token
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
//                .signWith(SignatureAlgorithm.HS256, secret)
//                .compact();
//    }
//
//    // Get username from token
//    public String getUsernameFromToken(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token)
//                .getBody();
//        return claims.getSubject();
//    }
//
//    // Validate token
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
