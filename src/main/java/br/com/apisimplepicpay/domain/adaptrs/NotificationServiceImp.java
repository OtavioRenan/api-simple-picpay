package br.com.apisimplepicpay.domain.adaptrs;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.exceptions.NotificationUnavailableException;
import br.com.apisimplepicpay.domain.ports.interfaces.NotificationServicePort;
import br.com.apisimplepicpay.domain.ports.repositories.NotificationRepositoryPort;

public class NotificationServiceImp implements NotificationServicePort {

    private final NotificationRepositoryPort repository;

    public NotificationServiceImp(NotificationRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void sendNotification(User user, String message) throws NotificationUnavailableException {
        if(!repository.sendNotification(user, message)) throw new NotificationUnavailableException();
    }
}
