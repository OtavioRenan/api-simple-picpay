package br.com.apisimplepicpay.domain.adaptrs;

import br.com.apisimplepicpay.domain.Transaction;
import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.dtos.UserDTO;
import br.com.apisimplepicpay.domain.dtos.recors.TransactionRecord;
import br.com.apisimplepicpay.domain.exceptions.OperationUnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;
import br.com.apisimplepicpay.domain.ports.interfaces.TransactionServicePort;
import br.com.apisimplepicpay.domain.ports.interfaces.UserServicePort;
import br.com.apisimplepicpay.domain.ports.repositories.TransactionRepositoryPort;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

public class TrasactionServiceImp implements TransactionServicePort {
    private final TransactionRepositoryPort repository;

    private final UserServicePort service;

    public TrasactionServiceImp(TransactionRepositoryPort repository, UserServicePort service) {
        this.repository = repository;
        this.service = service;
    }

    @Transactional
    @Override
    public void createTransaction(TransactionRecord transaction) throws UserNotFoundException, OperationUnauthorizedException {
        User sender = new User(service.findUserById(transaction.senderId()));

        User receiver = new User(service.findUserById(transaction.receiverId()));

        service.checkTransaction(sender, transaction.value());

        repository.createTransaction(new Transaction(transaction.value(), sender, receiver, LocalDateTime.now()));

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        service.saveUser(sender.toUserRecord());
        service.saveUser(receiver.toUserRecord());
    }

    private boolean authorizeTransaction() throws UnauthorizedException {
        if (repository.authorizeTransaction()) return true;

        throw new UnauthorizedException();
    }
}