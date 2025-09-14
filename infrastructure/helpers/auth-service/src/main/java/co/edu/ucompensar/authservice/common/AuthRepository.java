package co.edu.ucompensar.authservice.common;

import co.edu.ucompensar.authservice.model.Token;
import co.edu.ucompensar.authservice.model.User;

import java.util.List;

public interface AuthRepository {
    User saveUser(User user);
    void saveToken(Token token);
    User findUser(String email);
    List<Token> findActiveTokens(User user);
    Boolean updateTokens(List<Token> tokens);
    Token findToken(String token);
}
