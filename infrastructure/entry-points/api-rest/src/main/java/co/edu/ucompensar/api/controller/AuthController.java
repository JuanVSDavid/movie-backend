package co.edu.ucompensar.api.controller;

import co.edu.ucompensar.api.common.AuthService;
import co.edu.ucompensar.api.model.auth.TokenRequest;
import co.edu.ucompensar.api.model.auth.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@RequestBody final TokenRequest tokenRequest){
        return ResponseEntity.ok(authService.register(tokenRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody final TokenRequest tokenRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        tokenRequest.email(),
                        tokenRequest.password()
                )
        );
        return ResponseEntity.ok(authService.login(tokenRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refresh(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        return ResponseEntity.ok(authService.refreshToken(token));
    }
}
