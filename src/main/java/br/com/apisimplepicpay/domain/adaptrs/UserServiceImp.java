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
import java.util.List;

public class UserServiceImp implements UserServicePort {
    private final UserRepositoryPort repository;

    public UserServiceImp(UserRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<UserDTO> getUsers() {
        return repository.getUsers().stream().map(User::toUserDTO).toList();
    }

    @Override
    public UserDTO findUserById(Long userId) throws UserNotFoundException {
        return repository.findUserById(userId).toUserDTO();
    }

    @Override
    public UserDTO saveUser(UserRecord user) {
          return repository.saveUser(new User(user)).toUserDTO();
    }

    @Override
    public UserDTO saveUser(UserDTO dto, Long id) throws UserNotFoundException {
        User oldUser = repository.findUserById(id);

        User newUser = new User(dto);
        newUser.setPassword(oldUser.getPassword());

        return repository.saveUser(newUser).toUserDTO();
    }

    @Override
    public void checkTransaction(User sender, BigDecimal amount) throws OperationUnauthorizedException {
        if(!sender.getUserType().equals(UserTypeEnum.COMMON)) {
            throw new OperationUnauthorizedException("Usuários do tipo Logista não estão autorizados a realizar transações");
        } else if(sender.getBalance().compareTo(amount) < 0) {
            throw new OperationUnauthorizedException("Saldo insuficiente");
        }
    }
}
