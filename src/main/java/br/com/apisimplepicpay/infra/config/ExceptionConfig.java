package br.com.apisimplepicpay.infra.config;

import br.com.apisimplepicpay.domain.exceptions.NotificationUnavailableException;
import br.com.apisimplepicpay.domain.exceptions.OperationUnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UnauthorizedException;
import br.com.apisimplepicpay.domain.exceptions.UserNotFoundException;
import jakarta.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(OperationUnauthorizedException.class)
    ResponseEntity<Object> custonException(OperationUnauthorizedException e) {
        return new ResponseEntity<>(e.getMessage(), e.getStatus() );
    }

    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<Object> custonException(UserNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), e.getStatus() );
    }

    @ExceptionHandler(NotificationUnavailableException.class)
    ResponseEntity<Object> custonException(NotificationUnavailableException e) {
        return new ResponseEntity<>(e.getMessage(), e.getStatus() );
    }

    @ExceptionHandler(UnauthorizedException.class)
    ResponseEntity<Object> custonException(UnauthorizedException e) {
        return new ResponseEntity<>(e.getMessage(), e.getStatus() );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    ResponseEntity<Object> custonException(DataIntegrityViolationException e) {
        return new ResponseEntity<>("Documento já cadastrado.", HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<Object> custonException(HttpMessageNotReadableException e) {
        return new ResponseEntity<>("Existem valores inválidos.", HttpStatus.BAD_REQUEST );
    }

    ResponseEntity<Object> custonException(ConstraintViolationException e) {
        return new ResponseEntity<>(makeError(e), HttpStatus.UNPROCESSABLE_ENTITY );
    }

    private Map<String, String> makeError(ConstraintViolationException e) {
        Map<String, String> errs = new HashMap<>();

        e.getConstraintViolations().forEach(v -> errs.put(v.getPropertyPath().toString(), v.getMessage()));

        return errs;
    }
}

