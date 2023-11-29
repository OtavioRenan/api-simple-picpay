package br.com.apisimplepicpay.domain.exceptions;

import org.springframework.http.HttpStatus;

public class OperationUnauthorizedException extends Exception {
    private final HttpStatus status;

    public OperationUnauthorizedException(String message) {
        super(message);
        status = HttpStatus.FORBIDDEN;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
