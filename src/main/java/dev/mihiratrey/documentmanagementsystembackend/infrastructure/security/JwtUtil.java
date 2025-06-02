package dev.mihiratrey.documentmanagementsystembackend.infrastructure.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    
    private final long expirationMs = 3600000;
    
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    
    public String extractUsername(String token) {
        
        return Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(token)
                .getBody().getSubject();
    }

    private boolean isTokenExpired(String token) {
        final Date expiration = Jwts.parser().setSigningKey(secretKey).build()
                .parseClaimsJws(token).getBody().getExpiration();
        
        return expiration.before(new Date());
    }
    
    public boolean isValid(UserDetails userDetails, String token) {
        final String username = extractUsername(userDetails.getUsername());
        
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
}
