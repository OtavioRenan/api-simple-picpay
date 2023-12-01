package br.com.apisimplepicpay.domain.ports.repositories;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;

public interface UserRepositoryPort {
    User findUserById(Long id) throws UserNotFoundException;

    User findUserByDocument(String document) throws UserNotFoundException;

    User saveUser(User user);
}
