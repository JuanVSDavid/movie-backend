package co.edu.ucompensar.authservice.model;

import lombok.Builder;

@Builder
public record User(Long id, String email, String password) {
}
