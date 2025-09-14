package co.edu.ucompensar.jpa.mapper;

import co.edu.ucompensar.authservice.model.User;
import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDomainEntityMapper implements DomainEntityMapper<User, UserEntity> {
    @Override
    public UserEntity toEntity(User user) {
        return UserEntity.builder().email(user.email()).password(user.password()).build();
    }

    @Override
    public User toDomain(UserEntity userEntity) {
        return User.builder().id(userEntity.getId()).email(userEntity.getEmail()).password(userEntity.getPassword()).build();
    }
}
