package co.edu.ucompensar.api.common;

import co.edu.ucompensar.api.model.auth.TokenRequest;
import co.edu.ucompensar.api.model.auth.TokenResponse;
import co.edu.ucompensar.api.model.auth.UserRegistered;

import java.util.Optional;

public interface AuthService {
    Optional<UserRegistered> checkUser (String email);
    TokenResponse register(TokenRequest tokenRequest);
    TokenResponse login(TokenRequest tokenRequest);
    TokenResponse refreshToken(String token);
    Boolean isValidToken(String token);
    String extractEmail(String token);
}
