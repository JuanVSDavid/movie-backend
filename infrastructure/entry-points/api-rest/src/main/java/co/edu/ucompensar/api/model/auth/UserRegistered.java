package co.edu.ucompensar.api.model.auth;

import lombok.Builder;

@Builder
public record UserRegistered(String email, String password) {
}
