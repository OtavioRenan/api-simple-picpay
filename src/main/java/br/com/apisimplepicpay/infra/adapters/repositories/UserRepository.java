package br.com.apisimplepicpay.infra.adapters.repositories;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;
import br.com.apisimplepicpay.domain.ports.repositories.UserRepositoryPort;
import br.com.apisimplepicpay.infra.adapters.entities.UserEntity;
import br.com.apisimplepicpay.infra.adapters.jpas.UserEntityJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepository implements UserRepositoryPort {
    private final UserEntityJpaRepository repository;

    public UserRepository(UserEntityJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findUserById(Long id) throws UserNotFoundException {
        return toUser(repository.findById(id));
    }

    @Override
    public User findUserByDocument(String document) throws UserNotFoundException {
        return toUser(repository.findUserByDocument(document));
    }

    @Override
    public void saveUser(User user) {
        repository.save(new UserEntity(user)).toUser();
    }

    private User toUser(Optional<UserEntity> entity) throws UserNotFoundException {
        return entity.orElseThrow(UserNotFoundException::new).toUser();
    }
}