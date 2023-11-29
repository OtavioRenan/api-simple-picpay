package br.com.apisimplepicpay.domain.exceptions;

import org.springframework.http.HttpStatus;

public class NotificationUnavailableException extends Exception {
    private final HttpStatus status;

    public NotificationUnavailableException() {
        super("Serviço de e-mail indisponível");
        status = HttpStatus.UNAUTHORIZED;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
