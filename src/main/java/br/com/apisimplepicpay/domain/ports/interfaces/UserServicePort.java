package br.com.apisimplepicpay.domain.ports.interfaces;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.dtos.UserDTO;
import br.com.apisimplepicpay.domain.dtos.recors.UserRecord;
import br.com.apisimplepicpay.domain.exceptions.OperationUnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;

import java.math.BigDecimal;
import java.util.List;

public interface UserServicePort {
    UserDTO saveUser(UserRecord user);

    UserDTO saveUser(UserDTO dto, Long id) throws UserNotFoundException;

    UserDTO findUserById(Long userId) throws UserNotFoundException;

    List<UserDTO> getUsers();

    void checkTransaction(User sender, BigDecimal amount) throws OperationUnauthorizedException;
}