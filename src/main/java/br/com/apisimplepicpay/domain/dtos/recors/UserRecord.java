package br.com.apisimplepicpay.domain.dtos.recors;

import br.com.apisimplepicpay.domain.enums.UserTypeEnum;

import java.math.BigDecimal;

public record UserRecord(String firstName, String lastName, String document, String email, String password, BigDecimal balance, UserTypeEnum type) {
}