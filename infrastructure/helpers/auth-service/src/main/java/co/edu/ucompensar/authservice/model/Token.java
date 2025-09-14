package co.edu.ucompensar.authservice.model;

import lombok.Builder;

@Builder(toBuilder = true)
public record Token(Long id, User user, String token, Boolean expired, Boolean revoked) {
}
