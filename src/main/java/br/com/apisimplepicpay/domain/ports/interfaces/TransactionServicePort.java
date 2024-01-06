package br.com.apisimplepicpay.domain.ports.interfaces;

import br.com.apisimplepicpay.domain.dtos.TransactionDTO;
import br.com.apisimplepicpay.domain.exceptions.NotificationUnavailableException;
import br.com.apisimplepicpay.domain.exceptions.OperationUnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;

public interface TransactionServicePort {
    TransactionDTO createTransaction(TransactionDTO transaction) throws UserNotFoundException, OperationUnauthorizedException, NotificationUnavailableException, UnauthorizedException;
}
