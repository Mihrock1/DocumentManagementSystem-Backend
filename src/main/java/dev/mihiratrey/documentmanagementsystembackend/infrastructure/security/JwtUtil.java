package dev.mihiratrey.documentmanagementsystembackend.infrastructure.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;
    private SecretKey key;

//    SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    
    @PostConstruct
    public void init() {
        byte[] decodedSecret = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(decodedSecret);
    }
    
    private final long expirationMs = 3600000;
    
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key)
                .compact();
    }
    
    public String extractUsername(String token) {
        
        return Jwts.parser().setSigningKey(key).build().parseClaimsJws(token)
                .getBody().getSubject();
    }

    private boolean isTokenExpired(String token) {
        final Date expiration = Jwts.parser().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getExpiration();
        
        return expiration.before(new Date());
    }
    
    public boolean isValid(UserDetails userDetails, String token) {
        final String username = extractUsername(userDetails.getUsername());
        
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
}
