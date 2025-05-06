package com.victorxavier.modularmonolith.modules.payment.application.facade;

import com.victorxavier.modularmonolith.modules.payment.application.dto.ProcessPaymentInputDto;
import com.victorxavier.modularmonolith.modules.payment.application.dto.ProcessPaymentOutputDto;
import com.victorxavier.modularmonolith.modules.payment.application.facade.dto.PaymentFacadeInputDto;
import com.victorxavier.modularmonolith.modules.payment.application.facade.dto.PaymentFacadeOutputDto;
import com.victorxavier.modularmonolith.modules.payment.application.usecase.ProcessPaymentUseCase;

public class PaymentFacade implements PaymentFacadeInterface {

    private final ProcessPaymentUseCase processPaymentUseCase;

    public PaymentFacade(ProcessPaymentUseCase processPaymentUseCase) {
        this.processPaymentUseCase = processPaymentUseCase;
    }

    @Override
    public PaymentFacadeOutputDto process(PaymentFacadeInputDto input) {
        ProcessPaymentInputDto useCaseInput = new ProcessPaymentInputDto(
                input.getOrderId(),
                input.getAmount()
        );

        ProcessPaymentOutputDto output = processPaymentUseCase.execute(useCaseInput);

        return new PaymentFacadeOutputDto(
                output.getTransactionId(),
                output.getOrderId(),
                output.getAmount(),
                output.getStatus(),
                output.getCreatedAt(),
                output.getUpdatedAt()
        );
    }
}




