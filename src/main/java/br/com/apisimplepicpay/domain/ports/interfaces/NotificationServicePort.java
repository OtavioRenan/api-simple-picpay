package br.com.apisimplepicpay.domain.ports.interfaces;

import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.exceptions.NotificationUnavailableException;

public interface NotificationServicePort {
    void sendNotification(User user, String message) throws NotificationUnavailableException;
}
