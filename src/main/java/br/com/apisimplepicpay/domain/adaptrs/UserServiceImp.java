package br.com.apisimplepicpay.domain.adaptrs;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.dtos.UserDTO;
import br.com.apisimplepicpay.domain.dtos.recors.UserRecord;
import br.com.apisimplepicpay.domain.enums.UserTypeEnum;
import br.com.apisimplepicpay.domain.exceptions.OperationUnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;
import br.com.apisimplepicpay.domain.ports.interfaces.UserServicePort;
import br.com.apisimplepicpay.domain.ports.repositories.UserRepositoryPort;

import java.math.BigDecimal;

public class UserServiceImp implements UserServicePort {
    private final UserRepositoryPort repository;

    public UserServiceImp(UserRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public UserDTO findUserById(Long userId) throws UserNotFoundException {
        return repository.findUserById(userId).toUserDTO();
    }

    @Override
    public UserDTO saveUser(UserRecord record) {
          return  repository.saveUser(new User(record)).toUserDTO();
    }

    @Override
    public void checkTransaction(User sender, BigDecimal amount) throws OperationUnauthorizedException {
        if(!sender.getUserType().equals(UserTypeEnum.COMMON)) {
            throw new OperationUnauthorizedException("Usuários do tipo Logista não estão autorizados a realizar transações");
        } else if(sender.getBalance().compareTo(amount) > 0) {
            throw new OperationUnauthorizedException("Saldo insuficiente");
        }
    }
}
