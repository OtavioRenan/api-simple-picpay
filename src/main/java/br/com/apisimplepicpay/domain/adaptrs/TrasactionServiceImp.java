package br.com.apisimplepicpay.domain.adaptrs;

import br.com.apisimplepicpay.domain.Transaction;
import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.dtos.TransactionDTO;
import br.com.apisimplepicpay.domain.exceptions.NotificationUnavailableException;
import br.com.apisimplepicpay.domain.exceptions.OperationUnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;
import br.com.apisimplepicpay.domain.ports.interfaces.NotificationServicePort;
import br.com.apisimplepicpay.domain.ports.interfaces.TransactionServicePort;
import br.com.apisimplepicpay.domain.ports.interfaces.UserServicePort;
import br.com.apisimplepicpay.domain.ports.repositories.TransactionRepositoryPort;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

public class TrasactionServiceImp implements TransactionServicePort {
    private final TransactionRepositoryPort repository;

    private final UserServicePort service;

    private final NotificationServicePort notificationService;

    public TrasactionServiceImp(TransactionRepositoryPort repository, UserServicePort service, NotificationServicePort notificationService) {
        this.repository = repository;
        this.service = service;
        this.notificationService = notificationService;
    }

    @Transactional
    @Override
    public TransactionDTO createTransaction(TransactionDTO dto) throws UserNotFoundException, OperationUnauthorizedException, NotificationUnavailableException, UnauthorizedException {
        authorizeTransaction();

        User sender = new User(service.findUserById(dto.getSenderId()));

        User receiver = new User(service.findUserById(dto.getReceiverId()));

        service.checkTransaction(sender, dto.getValue());

        Transaction transaction = repository.createTransaction(new Transaction(dto.getValue(), sender, receiver, LocalDateTime.now()));

        sender.setBalance(sender.getBalance().subtract(dto.getValue()));
        receiver.setBalance(receiver.getBalance().add(dto.getValue()));

        service.saveUser(sender.toUserDTO(), sender.getId());
        service.saveUser(receiver.toUserDTO(), receiver.getId());

        notificationService.sendNotification(sender, "Transação realizada com sucesso.");
        notificationService.sendNotification(receiver, "Transação recebida com secesso.");

        return transaction.toTransactionDTO();
    }

    private void authorizeTransaction() throws UnauthorizedException {
        if (!repository.authorizeTransaction()) {
            throw new UnauthorizedException();
        }
    }
}