package br.com.apisimplepicpay.domain.controllers;

import br.com.apisimplepicpay.domain.dtos.UserDTO;
import br.com.apisimplepicpay.domain.dtos.recors.UserRecord;
import br.com.apisimplepicpay.domain.ports.interfaces.UserServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {
    private final UserServicePort service;

    public UserController(UserServicePort service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(UserRecord user) {
        UserDTO success = service.saveUser(user);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }
}
