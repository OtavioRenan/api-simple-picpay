package br.com.apisimplepicpay.domain.ports.repositories;

import br.com.apisimplepicpay.domain.Transaction;

public interface TransactionRepositoryPort {
    void createTransaction(Transaction transaction);

    boolean authorizeTransaction();
}