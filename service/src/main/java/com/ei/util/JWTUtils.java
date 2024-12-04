package com.ei.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * @author yitiansong
 * jwt 工具类
 */
@Component
public class JWTUtils {
    private static SecretKey jwtSecret;
    // 通过@Value注解和set方法注入jwtSecret
    @Value("${app.jwtSecret}")
    public void setJwtSecret(String secret) {
        jwtSecret = Keys.hmacShaKeyFor(secret.getBytes());
    }
    /**
     * Generates a JWT token for the given username.
     *
     * @param username the username for which the token will be generated
     * @return the generated JWT token
     */
    public static String generateToken(String username) {
        String token = Jwts.builder()
                .subject(username)
                .signWith(jwtSecret, Jwts.SIG.HS256)
                // 过期时间3天
                .expiration(new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000))
                .compact();
        return token;
    }

    /**
     * Validates the given token for the specified username.
     *
     * @param token    the token to be validated
     * @param username the username to be checked against the token
     * @return true if the token is valid for the given username, false otherwise
     */
    public static boolean validateToken(String token, String username) {
        Jws<Claims> claimsJws = Jwts.parser()
                .verifyWith(jwtSecret)
                .build()
                .parseSignedClaims(token);
        Claims claims = claimsJws.getPayload();
        return claims.getSubject().equals(username);
    }

    /**
     * Retrieves the username from the given token.
     *
     * @param token the token from which to retrieve the username
     * @return the username extracted from the token, or null if the token is expired
     */
    public static String getUsernameFromToken(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(jwtSecret)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        } catch (ExpiredJwtException e) {
            return null;
        }
    }

    /**
     * Validates the given token.
     *
     * @param token the token to be validated
     * @return true if the token is valid, false otherwise
     */
    public static boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(jwtSecret)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
