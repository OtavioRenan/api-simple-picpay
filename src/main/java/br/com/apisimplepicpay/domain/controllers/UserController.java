package br.com.apisimplepicpay.domain.controllers;

import br.com.apisimplepicpay.domain.dtos.UserDTO;
import br.com.apisimplepicpay.domain.dtos.recors.UserRecord;
import br.com.apisimplepicpay.domain.ports.interfaces.UserServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServicePort service;

    public UserController(UserServicePort service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserRecord user) {
        return new ResponseEntity<>(service.saveUser(user), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }
}