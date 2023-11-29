package br.com.apisimplepicpay.infra.adapters.repositories;

import br.com.apisimplepicpay.domain.Notification;
import br.com.apisimplepicpay.domain.User;
import br.com.apisimplepicpay.domain.ports.repositories.NotificationRepositoryPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Component
public class NotificationRepository implements NotificationRepositoryPort {
    private final RestTemplate restTemplate;

    @Value("${picpay.service.mail.url}")
    private String emailService;

    public NotificationRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean sendNotification(User user, String message) {
        ResponseEntity<Map> response = restTemplate
                .postForEntity(emailService,new Notification(user.getEmail(), message), Map.class);

        String msg = Objects.requireNonNull(response.getBody()).get("message").toString();

        return response.getStatusCode().equals(HttpStatus.OK) && "true".equalsIgnoreCase(msg);
    }
}
