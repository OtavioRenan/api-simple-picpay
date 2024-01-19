package br.com.apisimplepicpay.memory;

import br.com.apisimplepicpay.domain.adaptrs.UserServiceImp;
import br.com.apisimplepicpay.domain.dtos.UserDTO;
import br.com.apisimplepicpay.domain.dtos.recors.UserRecord;
import br.com.apisimplepicpay.domain.enums.UserTypeEnum;
import br.com.apisimplepicpay.domain.ports.interfaces.UserServicePort;
import br.com.apisimplepicpay.domain.ports.repositories.UserRepositoryPort;
import br.com.apisimplepicpay.infra.adapters.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class UserServiceImpTestDB {
    @Autowired
    private UserRepositoryPort repository;

    private UserServicePort service;

    @BeforeEach
    public void setup() {
        service = new UserServiceImp(repository);
    }

    @Test
    void success_when_access_findAll() {
        service.saveUser(buidUserRecord());

        List<UserDTO> actual = service.getUsers();

        assertEquals(0, 0);
    }

    private UserRecord buidUserRecord() {
        return new UserRecord("Renan", "Menezes", "123456789",
                "renan@email.com", "123456789", BigDecimal.valueOf(0), UserTypeEnum.COMMON);
    }
}
