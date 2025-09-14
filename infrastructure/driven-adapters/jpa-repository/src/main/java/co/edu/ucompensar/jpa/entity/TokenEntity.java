package co.edu.ucompensar.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tokens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenEntity {
    public static final String BEARER = "Bearer";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String token;
    @Column(name = "token_type")
    private final String tokenType = BEARER;
    @Column(name = "user_id")
    private Long user;
    @Column
    private Boolean revoked;
    @Column
    private Boolean expired;
}
