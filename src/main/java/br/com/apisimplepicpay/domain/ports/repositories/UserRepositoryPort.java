package br.com.apisimplepicpay.domain.ports.repositories;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;

import java.util.List;

public interface UserRepositoryPort {
    User findUserById(Long id) throws UserNotFoundException;

    List<User> getUsers();

    User findUserByDocument(String document) throws UserNotFoundException;

    User saveUser(User user);
}
