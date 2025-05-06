package com.victorxavier.modularmonolith.modules.payment.domain.gateway;

import com.victorxavier.modularmonolith.modules.payment.domain.entity.TransactionEntity;

public interface ProcessPaymentGateway {
    TransactionEntity save(TransactionEntity transactionEntity);
}
