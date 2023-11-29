package br.com.apisimplepicpay.infra.adapters.entities;

import br.com.apisimplepicpay.domain.Transaction;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal amount;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity sender;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private UserEntity receiver;

    @NotNull
    private LocalDateTime timestamp;

    public TransactionEntity() {
    }

    public TransactionEntity(Transaction entity) {
        id = entity.getId();
        amount = entity.getAmount();
        sender = new UserEntity(entity.getSender());
        receiver = new UserEntity(entity.getReceiver());
        timestamp = entity.getTimestamp();
    }

    public Transaction toTransaction() {
        return  new Transaction(this);
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

    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public UserEntity getReceiver() {
        return receiver;
    }

    public void setReceiver(UserEntity receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}