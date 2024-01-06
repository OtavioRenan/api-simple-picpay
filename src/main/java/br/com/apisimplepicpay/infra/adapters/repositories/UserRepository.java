package br.com.apisimplepicpay.infra.adapters.repositories;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;
import br.com.apisimplepicpay.domain.ports.repositories.UserRepositoryPort;
import br.com.apisimplepicpay.infra.adapters.entities.UserEntity;
import br.com.apisimplepicpay.infra.adapters.jpas.UserEntityJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository implements UserRepositoryPort {
    private final UserEntityJpaRepository repository;

    public UserRepository(UserEntityJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll().stream().map(UserEntity::toUser).toList();
    }

    @Override
    public User findUserById(Long id) throws UserNotFoundException {
        return repository.findById(id).orElseThrow(UserNotFoundException::new).toUser();
    }

    @Override
    public User findUserByDocument(String document) throws UserNotFoundException {
        return repository.findUserByDocument(document).orElseThrow(UserNotFoundException::new).toUser();
    }

    @Override
    public User saveUser(User user) {
        return repository.save(new UserEntity(user)).toUser();
    }
}