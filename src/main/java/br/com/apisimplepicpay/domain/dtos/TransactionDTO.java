package br.com.apisimplepicpay.domain.dtos;

import java.math.BigDecimal;

public class TransactionDTO {
    BigDecimal value;

    Long senderId;

    Long receiverId;

    public TransactionDTO(BigDecimal value, Long senderId, Long receiverId) {
        this.value = value;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }
}
