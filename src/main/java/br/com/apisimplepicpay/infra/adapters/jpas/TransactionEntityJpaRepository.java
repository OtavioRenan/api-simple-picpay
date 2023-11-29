package br.com.apisimplepicpay.infra.adapters.jpas;

import br.com.apisimplepicpay.infra.adapters.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityJpaRepository extends JpaRepository<TransactionEntity, Long> {
}
