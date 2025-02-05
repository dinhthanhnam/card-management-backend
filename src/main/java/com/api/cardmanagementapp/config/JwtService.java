package com.api.cardmanagementapp.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtService {
    private static final String SECRET_KEY = "8482E372C22DD9A2A6A8533D58F4E"; // Thay bằng khóa bí mật thực tế

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public <T> T extractClaim(String token, String claimName, Class<T> clazz) {
        Claims claims = extractAllClaims(token);
        return claims.get(claimName, clazz);
    }

    public String extractUsername(String token) {
        return null;
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser() // parser() vẫn đúng
                .verifyWith(getSigningKey()) // Dùng verifyWith() để xác thực
                .build()
                .parseSignedClaims(token) // Sử dụng parseSignedClaims() thay vì parseClaimsJws()
                .getPayload(); // Lấy payload thay vì getBody()
    }
}
