package br.com.apisimplepicpay.infra.adapters.repositories;

import br.com.apisimplepicpay.domain.Transaction;
import br.com.apisimplepicpay.domain.ports.repositories.TransactionRepositoryPort;
import br.com.apisimplepicpay.infra.adapters.entities.TransactionEntity;
import br.com.apisimplepicpay.infra.adapters.jpas.TransactionEntityJpaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Component
public class TrasactionRepository implements TransactionRepositoryPort {
    private final TransactionEntityJpaRepository repository;

    private final RestTemplate restTemplate;

    @Value("${picpay.authorization.url}")
    private String authorization;

    public TrasactionRepository(TransactionEntityJpaRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @Override
    public void createTransaction(Transaction transaction) {
        repository.save(new TransactionEntity(transaction));
    }

    @Override
    public boolean authorizeTransaction() {
        ResponseEntity<Map> response = restTemplate.getForEntity(authorization, Map.class);

        String mesage = Objects.requireNonNull(response.getBody()).get("message").toString();

        return response.getStatusCode().equals(HttpStatus.OK) && "Autorizado".equalsIgnoreCase(mesage);
    }
}