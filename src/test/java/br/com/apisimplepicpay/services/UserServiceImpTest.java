package br.com.apisimplepicpay.services;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.adaptrs.UserServiceImp;
import br.com.apisimplepicpay.domain.dtos.UserDTO;
import br.com.apisimplepicpay.domain.enums.UserTypeEnum;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;
import br.com.apisimplepicpay.domain.ports.interfaces.UserServicePort;
import br.com.apisimplepicpay.domain.ports.repositories.UserRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {
    @Mock
    private UserRepositoryPort repository;

    private UserServicePort service;

    private static final User RECEIVER = new User(1L, "Renan", "Menezes", "123456789", "123456789", "renan@email.com", BigDecimal.valueOf(0), UserTypeEnum.COMMON);

    private static final User SENDER = new User(2L, "Otavio", "Conceição", "987654321", "987654321", "renan@email.com", BigDecimal.valueOf(0), UserTypeEnum.COMMON);

    @BeforeEach
    public void setup() throws UserNotFoundException {
        service = new UserServiceImp(repository);
    }

    @Test
    void success_when_acess_findAll() {
        when(repository.getUsers()).thenReturn(mockUsers());

        List<UserDTO> actual = service.getUsers();

        List<UserDTO> expected = new ArrayList<>();
        expected.add(RECEIVER.toUserDTO());
        expected.add(SENDER.toUserDTO());

        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0), actual.get(0));
        assertEquals(expected.get(1), actual.get(1));
    }

    private List<User> mockUsers() {
        List<User> users = new ArrayList<>();
        users.add(RECEIVER);
        users.add(SENDER);

        return users;
    }
}