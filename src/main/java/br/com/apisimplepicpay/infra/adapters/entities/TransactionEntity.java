package br.com.apisimplepicpay.infra.adapters.entities;

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
}