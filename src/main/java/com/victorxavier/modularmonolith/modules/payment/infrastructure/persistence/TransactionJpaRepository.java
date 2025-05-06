package com.victorxavier.modularmonolith.modules.payment.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionJpaRepository extends JpaRepository<TransactionJpaEntity, String> {

}
