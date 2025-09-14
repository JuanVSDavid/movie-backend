package co.edu.ucompensar.jpa.repository;

import co.edu.ucompensar.jpa.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TokenEntityRepository extends JpaRepository<TokenEntity, Long> {
    List<TokenEntity> findAllRevokedIsFalseAndExpiredIsFalseByUser(Long user);
    TokenEntity findByToken(String token);
}
