package co.edu.ucompensar.authservice.common;

import co.edu.ucompensar.authservice.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtServiceImpl implements JwtService{
    private final String secretKey;
    private final Long expirationTime;
    private final Long refreshExpirationTime;

    public JwtServiceImpl(
            @Value("${security.jwt.secret-key}") String secretKey,
            @Value("${security.jwt.expiration}") Long expirationTime,
            @Value("${security.jwt.refresh-token.expiration}") Long refreshExpirationTime
    ) {
        this.secretKey = secretKey;
        this.expirationTime = expirationTime;
        this.refreshExpirationTime = refreshExpirationTime;
    }


    @Override
    public String generateToken(User user) {
        return buildToken(user, expirationTime);
    }

    @Override
    public String generateRefreshToken(User user) {
        return buildToken(user, refreshExpirationTime);
    }

    @Override
    public String extractEmail(String token) {
        final Claims jwtToken = getPayload(token);
        return jwtToken.getSubject();
    }

    private Claims getPayload(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    @Override
    public boolean isTokenValid(String token, User user) {
        final String email = extractEmail(token);
        return email.equals(user.email()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getPayload(token).getExpiration().before(new Date());
    }

    private String buildToken(final User user, final Long expirationTime){
        return Jwts
                .builder()
                .id(UUID.randomUUID().toString())
                .subject(user.email())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSignInKey())
                .compact();
    }

    private SecretKey getSignInKey(){
        var keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
