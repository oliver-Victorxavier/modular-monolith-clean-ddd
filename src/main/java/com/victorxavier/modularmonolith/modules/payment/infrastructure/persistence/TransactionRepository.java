package com.victorxavier.modularmonolith.modules.payment.infrastructure.persistence;

import com.victorxavier.modularmonolith.modules.payment.domain.entity.TransactionEntity;
import com.victorxavier.modularmonolith.modules.payment.domain.gateway.ProcessPaymentGateway;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class TransactionRepository implements ProcessPaymentGateway {
    private final TransactionJpaRepository repository;

    public TransactionRepository(TransactionJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransactionEntity save(TransactionEntity transaction) {
        TransactionJpaEntity jpaEntity = new TransactionJpaEntity();
        jpaEntity.setId(transaction.getId().toString());
        jpaEntity.setOrderId(transaction.getOrderId());
        jpaEntity.setAmount(transaction.getAmount());
        jpaEntity.setStatus(transaction.getStatus());
        jpaEntity.setCreatedAt(transaction.getCreatedAt());
        jpaEntity.setUpdatedAt(transaction.getUpdatedAt());

        TransactionJpaEntity savedEntity = repository.save(jpaEntity);

        return new TransactionEntity(
                UUID.fromString(savedEntity.getId()),
                savedEntity.getAmount(),
                savedEntity.getOrderId(),
                savedEntity.getStatus(),
                savedEntity.getCreatedAt(),
                savedEntity.getUpdatedAt()
        );
    }
}
