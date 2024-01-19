package br.com.apisimplepicpay.memory;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.adaptrs.UserServiceImp;
import br.com.apisimplepicpay.domain.dtos.UserDTO;
import br.com.apisimplepicpay.domain.dtos.recors.UserRecord;
import br.com.apisimplepicpay.domain.enums.UserTypeEnum;
import br.com.apisimplepicpay.domain.ports.interfaces.UserServicePort;
import br.com.apisimplepicpay.domain.ports.repositories.UserRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserServiceImpInMemoryTest {
    @Autowired
    private UserRepositoryPort repository;

    private UserServicePort service;

    @BeforeEach
    public void setup() {
        service = new UserServiceImp(repository);
    }

    @Test
    void success_when_access_findAll() {
        List<UserDTO> listEmpty = service.getUsers();

        service.saveUser(buidUserRecord());

        List<UserDTO> listWithUser = service.getUsers();

        assertEquals(0, listEmpty.size());
        assertEquals(1, listWithUser.size());
        assertEquals(buildUser().toUserDTO(), listWithUser.get(0));
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
