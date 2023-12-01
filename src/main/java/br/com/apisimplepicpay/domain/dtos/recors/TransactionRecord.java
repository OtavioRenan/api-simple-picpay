package br.com.apisimplepicpay.domain.dtos.recors;

import java.math.BigDecimal;

public record TransactionRecord(BigDecimal value, Long senderId, Long receiverId) {
}