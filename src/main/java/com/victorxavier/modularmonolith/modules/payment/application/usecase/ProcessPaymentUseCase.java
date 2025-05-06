package com.victorxavier.modularmonolith.modules.payment.application.usecase;


import com.victorxavier.modularmonolith.modules.payment.application.dto.ProcessPaymentInputDto;
import com.victorxavier.modularmonolith.modules.payment.application.dto.ProcessPaymentOutputDto;
import com.victorxavier.modularmonolith.modules.payment.domain.entity.TransactionEntity;
import com.victorxavier.modularmonolith.modules.payment.domain.gateway.ProcessPaymentGateway;
import com.victorxavier.modularmonolith.shared.usecase.UseCase;

public class ProcessPaymentUseCase implements UseCase<ProcessPaymentInputDto, ProcessPaymentOutputDto> {
    private final ProcessPaymentGateway paymentGateway;

    public ProcessPaymentUseCase(ProcessPaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public ProcessPaymentOutputDto execute(ProcessPaymentInputDto input) {
        TransactionEntity transaction = new TransactionEntity(
                null,
                input.getAmount(),
                input.getOrderId()
        );

        transaction.process();
        TransactionEntity savedTransaction = paymentGateway.save(transaction);

        return new ProcessPaymentOutputDto(
                savedTransaction.getId().toString(),
                savedTransaction.getOrderId(),
                savedTransaction.getAmount(),
                savedTransaction.getStatus(),
                savedTransaction.getCreatedAt(),
                savedTransaction.getUpdatedAt()
        );
    }
}
