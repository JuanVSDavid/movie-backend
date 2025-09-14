package co.edu.ucompensar.jpa.mapper;

import co.edu.ucompensar.authservice.model.Token;
import co.edu.ucompensar.authservice.model.User;
import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.TokenEntity;
import org.springframework.stereotype.Component;

@Component
public class TokenDomainEntityMapper implements DomainEntityMapper<Token, TokenEntity> {
    @Override
    public TokenEntity toEntity(Token token) {
        return TokenEntity.builder()
                .token(token.token())
                .user(token.user().id())
                .expired(token.expired())
                .revoked(token.revoked())
                .id(token.id())
                .build();
    }

    @Override
    public Token toDomain(TokenEntity tokenEntity) {
        return Token
                .builder()
                .token(tokenEntity.getToken())
                .expired(tokenEntity.getExpired())
                .revoked(tokenEntity.getRevoked())
                .id(tokenEntity.getId())
                .user(User.builder().id(tokenEntity.getUser()).build())
                .build();
    }
}
