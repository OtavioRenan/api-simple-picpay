package br.com.apisimplepicpay.infra.config;

import br.com.apisimplepicpay.domain.adaptrs.TrasactionServiceImp;
import br.com.apisimplepicpay.domain.adaptrs.UserServiceImp;
import br.com.apisimplepicpay.domain.ports.interfaces.TransactionServicePort;
import br.com.apisimplepicpay.domain.ports.interfaces.UserServicePort;
import br.com.apisimplepicpay.domain.ports.repositories.TransactionRepositoryPort;
import br.com.apisimplepicpay.domain.ports.repositories.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    UserServicePort userService(UserRepositoryPort repository) {
        return new UserServiceImp(repository);
    }

    @Bean
    TransactionServicePort transactionService(TransactionRepositoryPort transactionRepository, UserRepositoryPort userRepository) {
        return new TrasactionServiceImp(transactionRepository, userService(userRepository));
    }
}