package co.edu.ucompensar.authservice.common;

import co.edu.ucompensar.authservice.model.User;

public interface JwtService {
    String generateToken(User user);
    String generateRefreshToken(User user);
    String extractEmail(String token);
    boolean isTokenValid(String token, User user);
}
