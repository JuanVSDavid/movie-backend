package co.edu.ucompensar.jpa.repository;

import co.edu.ucompensar.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
