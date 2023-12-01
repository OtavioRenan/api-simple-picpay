package br.com.apisimplepicpay.domain.ports.interfaces;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.dtos.UserDTO;
import br.com.apisimplepicpay.domain.dtos.recors.UserRecord;
import br.com.apisimplepicpay.domain.exceptions.OperationUnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;

import java.math.BigDecimal;

public interface UserServicePort {
    UserDTO saveUser(UserRecord user);

    UserDTO findUserById(Long userId) throws UserNotFoundException;

    void checkTransaction(User sender, BigDecimal amount) throws OperationUnauthorizedException;
}