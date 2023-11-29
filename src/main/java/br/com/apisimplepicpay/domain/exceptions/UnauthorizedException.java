package br.com.apisimplepicpay.domain.exceptions;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends Exception {
    private final HttpStatus status;

    public UnauthorizedException() {
        super("Usuário não autorizado");
        status = HttpStatus.UNAUTHORIZED;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
