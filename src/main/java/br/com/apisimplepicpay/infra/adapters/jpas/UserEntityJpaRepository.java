package br.com.apisimplepicpay.infra.adapters.jpas;

import br.com.apisimplepicpay.infra.adapters.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEntityJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByDocument(String document);
}
