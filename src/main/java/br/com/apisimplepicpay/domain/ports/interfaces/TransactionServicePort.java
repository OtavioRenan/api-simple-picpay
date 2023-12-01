package br.com.apisimplepicpay.domain.ports.interfaces;

import br.com.apisimplepicpay.domain.dtos.recors.TransactionRecord;
import br.com.apisimplepicpay.domain.exceptions.OperationUnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;

public interface TransactionServicePort {
    void createTransaction(TransactionRecord transaction) throws UserNotFoundException, OperationUnauthorizedException;
}
