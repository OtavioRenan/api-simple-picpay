package br.com.apisimplepicpay.domain.ports.repositories;

import br.com.apisimplepicpay.domain.User;

public interface NotificationRepositoryPort {
    boolean sendNotification(User user, String message);
}
