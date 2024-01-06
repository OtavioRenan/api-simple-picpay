package br.com.apisimplepicpay.domain.ports.repositories;

import br.com.apisimplepicpay.domain.Transaction;

public interface TransactionRepositoryPort {
    Transaction createTransaction(Transaction transaction);

    boolean authorizeTransaction();
}