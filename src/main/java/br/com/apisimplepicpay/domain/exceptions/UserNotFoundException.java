package br.com.apisimplepicpay.domain.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends Exception {
    private final HttpStatus status;

    public UserNotFoundException() {
        super("Usuário não encontrado");
        status = HttpStatus.NOT_FOUND;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
