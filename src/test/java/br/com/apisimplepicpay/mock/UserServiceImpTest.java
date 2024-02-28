package br.com.apisimplepicpay.mock;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.adaptrs.UserServiceImp;
import br.com.apisimplepicpay.domain.dtos.UserDTO;
import br.com.apisimplepicpay.domain.dtos.recors.UserRecord;
import br.com.apisimplepicpay.domain.enums.UserTypeEnum;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;
import br.com.apisimplepicpay.domain.ports.interfaces.UserServicePort;
import br.com.apisimplepicpay.domain.ports.repositories.UserRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {
    @Mock
    private UserRepositoryPort repository;

    private UserServicePort service;

    @BeforeEach
    public void setup() {
        service = new UserServiceImp(repository);
    }

    @Test
    void success_when_access_findAll() {
        when(repository.getUsers()).thenReturn(List.of(buildUser()));

        List<UserDTO> expected = List.of(buildUser().toUserDTO());

        List<UserDTO> actual = service.getUsers();

        assertEquals(actual.size(), expected.size());
        assertEquals(actual.get(0), expected.get(0));
    }

    @Test
    void success_when_access_findUserById() throws UserNotFoundException {
        when(repository.findUserById(buildUser().getId())).thenReturn(buildUser());

        UserDTO actual = service.findUserById(buildUser().getId());

        assertEquals(actual, buildUser().toUserDTO());
    }

    @Test
    void error_when_access_findUserById() {
        assertThrows(UserNotFoundException.class, () -> service.findUserById(anyLong()));
    }

    @Test
    void success_when_save_user() {
        when(repository.saveUser(Mockito.any(User.class))).thenReturn(buildUser());

        UserDTO actual = service.saveUser(buidUserRecord());

        assertEquals(actual, buildUser().toUserDTO());
    }

    private User buildUser() {
        User user = new User("Renan", "Menezes", "123456789",
        "renan@email.com", "123456789", BigDecimal.valueOf(0), UserTypeEnum.COMMON);
        user.setId(1L);
        return user;
    }

    private UserRecord buidUserRecord() {
        return new UserRecord("Renan", "Menezes", "123456789",
        "renan@email.com", "123456789", BigDecimal.valueOf(0), UserTypeEnum.COMMON);
    }
}