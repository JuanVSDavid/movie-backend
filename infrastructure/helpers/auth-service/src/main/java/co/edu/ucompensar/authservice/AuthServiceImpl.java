package co.edu.ucompensar.authservice;

import co.edu.ucompensar.api.common.AuthService;
import co.edu.ucompensar.api.model.auth.TokenRequest;
import co.edu.ucompensar.api.model.auth.TokenResponse;
import co.edu.ucompensar.api.model.auth.UserRegistered;
import co.edu.ucompensar.authservice.common.AuthRepository;
import co.edu.ucompensar.authservice.common.JwtService;
import co.edu.ucompensar.authservice.model.Token;
import co.edu.ucompensar.authservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public Optional<UserRegistered> checkUser(String email) {
        return Optional.of(repository.findUser(email))
                .map(user -> UserRegistered.builder().email(user.email()).password(user.password()).build());
    }

    @Override
    public TokenResponse register(TokenRequest tokenRequest) {
        var user = User.builder()
                .email(tokenRequest.email())
                .password(passwordEncoder.encode(tokenRequest.password()))
                .build();
        var savedUser = repository.saveUser(user);
        var token = jwtService.generateToken(savedUser);
        var refreshToken = jwtService.generateRefreshToken(savedUser);
        saveUserToken(token, savedUser);
        return TokenResponse.builder().accessToken(token).refreshToken(refreshToken).build();
    }

    private void saveUserToken(String token, User savedUser) {
        repository.saveToken(
                Token.builder()
                        .token(token)
                        .expired(Boolean.FALSE)
                        .revoked(Boolean.FALSE)
                        .user(savedUser)
                        .build()
        );
    }

    @Override
    public TokenResponse login(TokenRequest tokenRequest) {
        var user = repository.findUser(tokenRequest.email());
        revokeAllUserTokens(user);
        var token = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(token, user);
        return TokenResponse.builder().accessToken(token).refreshToken(refreshToken).build();
    }

    private void revokeAllUserTokens(User user) {
        Optional.of(
                repository
                        .findActiveTokens(user)
                        .stream()
                        .map(token -> token.toBuilder().revoked(Boolean.TRUE).expired(Boolean.TRUE).build())
                        .collect(Collectors.toCollection(ArrayList::new))
        ).map(repository::updateTokens);

    }

    @Override
    public TokenResponse refreshToken(String token) {
        if (Objects.isNull(token) || !token.startsWith("Bearer ")){
            throw new IllegalArgumentException("Invalid Bearer token");
        }
        final String tokenCleaned = token.substring(7);
        final String userEmail = jwtService.extractEmail(tokenCleaned);
        if (Objects.isNull(userEmail)){
            throw new IllegalArgumentException("Invalid Bearer token");
        }
        final User user = Optional.of(repository.findUser(userEmail))
                .orElseThrow(() -> new IllegalArgumentException("User not found"));;
        if (!jwtService.isTokenValid(tokenCleaned, user)){
            throw new IllegalArgumentException("Invalid Bearer token");
        }
        revokeAllUserTokens(user);
        var newToken = jwtService.generateToken(user);
        saveUserToken(token, user);
        return TokenResponse.builder().accessToken(newToken).refreshToken(tokenCleaned).build();
    }

    @Override
    public Boolean isValidToken(String token) {
        final Token tokenSaved = repository.findToken(token);
        if (Objects.isNull(tokenSaved)){
            return Boolean.FALSE;
        }
        final String userEmail = jwtService.extractEmail(token);
        if (Objects.isNull(userEmail)){
            return Boolean.FALSE;
        }
        final User user = repository.findUser(userEmail);
        if (Objects.isNull(user)){
            return Boolean.FALSE;
        }
        return !tokenSaved.expired() || !tokenSaved.revoked();
    }

    @Override
    public String extractEmail(String token) {
        return jwtService.extractEmail(token);
    }
}
