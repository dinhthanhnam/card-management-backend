package com.api.cardmanagementapp.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY = "ko59K2mtVYzOhblzDR5bbVrsr96IdfEuSiBSyzTzGJB3xxVis/dTSX5cHGtULPW3"; // Thay bằng khóa bí mật thực tế
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .claims(extraClaims) // Thêm claims tùy chỉnh
                .subject(userDetails.getUsername()) // Đặt subject là username
                .issuedAt(new Date(System.currentTimeMillis())) // Ngày tạo token
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Hết hạn sau 24 giờ
                .signWith(getSigningKey()) // Ký bằng HMAC SHA256
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser() // parser() vẫn đúng
                .verifyWith(getSigningKey()) // Dùng verifyWith() để xác thực
                .build()
                .parseSignedClaims(token) // Sử dụng parseSignedClaims() thay vì parseClaimsJws()
                .getPayload(); // Lấy payload thay vì getBody()
    }
}
