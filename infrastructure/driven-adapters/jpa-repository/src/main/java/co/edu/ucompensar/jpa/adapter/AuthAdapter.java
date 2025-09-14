package co.edu.ucompensar.jpa.adapter;

import co.edu.ucompensar.authservice.common.AuthRepository;
import co.edu.ucompensar.authservice.model.Token;
import co.edu.ucompensar.authservice.model.User;
import co.edu.ucompensar.jpa.common.DomainEntityMapper;
import co.edu.ucompensar.jpa.entity.TokenEntity;
import co.edu.ucompensar.jpa.entity.UserEntity;
import co.edu.ucompensar.jpa.repository.TokenEntityRepository;
import co.edu.ucompensar.jpa.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class AuthAdapter implements AuthRepository {
    private final UserEntityRepository userEntityRepository;
    private final TokenEntityRepository tokenEntityRepository;
    private final DomainEntityMapper<User, UserEntity> userDomainEntityMapper;
    private final DomainEntityMapper<Token, TokenEntity> tokenDomainEntityMapper;

    @Override
    public User saveUser(User user) {
        return userDomainEntityMapper.toDomain(userEntityRepository.save(userDomainEntityMapper.toEntity(user)));
    }

    @Override
    public void saveToken(Token token) {
        tokenEntityRepository.save(tokenDomainEntityMapper.toEntity(token));
    }

    @Override
    public User findUser(String email) {
        return userDomainEntityMapper.toDomain(userEntityRepository.findByEmail(email));
    }

    @Override
    public List<Token> findActiveTokens(User user) {
        return tokenEntityRepository.findAllRevokedIsFalseAndExpiredIsFalseByUser(user.id())
                .stream()
                .map(tokenDomainEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Boolean updateTokens(List<Token> tokens) {
        return !tokenEntityRepository.saveAll(tokens.stream().map(tokenDomainEntityMapper::toEntity).toList()).isEmpty();
    }

    @Override
    public Token findToken(String token) {
        return tokenDomainEntityMapper.toDomain(tokenEntityRepository.findByToken(token));
    }
}
