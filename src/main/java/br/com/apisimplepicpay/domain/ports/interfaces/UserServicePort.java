package br.com.apisimplepicpay.domain.ports.interfaces;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.dtos.UserDTO;
import br.com.apisimplepicpay.domain.exceptions.OperationUnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;

import java.math.BigDecimal;

public interface UserServicePort {
    void saveUser(UserDTO dto);

    User findUserById(Long userId) throws UserNotFoundException;

    void checkTransaction(User sender, BigDecimal amount) throws OperationUnauthorizedException;
}