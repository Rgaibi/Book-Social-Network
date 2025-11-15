package com.karim.Book_network.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository {
    Optional<Token> findByToken(String token);
}
