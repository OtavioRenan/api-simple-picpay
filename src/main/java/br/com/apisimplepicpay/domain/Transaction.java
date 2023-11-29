package br.com.apisimplepicpay.domain;

import br.com.apisimplepicpay.infra.adapters.entities.TransactionEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private Long id;

    private BigDecimal amount;

    private User sender;

    private User receiver;

    private LocalDateTime timestamp;

    public Transaction(TransactionEntity entity) {
        id = entity.getId();
        amount = entity.getAmount();
        sender = entity.getSender().toUser();
        receiver = entity.getReceiver().toUser();
        timestamp = entity.getTimestamp();
    }

    public Transaction(BigDecimal amount, User sender, User receiver, LocalDateTime timestamp) {
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}