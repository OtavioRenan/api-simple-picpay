package br.com.apisimplepicpay.domain.controllers;

import br.com.apisimplepicpay.domain.dtos.TransactionDTO;
import br.com.apisimplepicpay.domain.exceptions.NotificationUnavailableException;
import br.com.apisimplepicpay.domain.exceptions.OperationUnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;
import br.com.apisimplepicpay.domain.ports.interfaces.TransactionServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionServicePort service;

    public TransactionController(TransactionServicePort service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> createTransaction(@RequestBody TransactionDTO transaction) throws UserNotFoundException, OperationUnauthorizedException, NotificationUnavailableException, UnauthorizedException {
        return new ResponseEntity<>(service.createTransaction(transaction), HttpStatus.OK);
    }
}
