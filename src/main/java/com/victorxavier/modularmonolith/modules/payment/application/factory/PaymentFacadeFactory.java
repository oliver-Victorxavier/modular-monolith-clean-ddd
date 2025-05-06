package com.victorxavier.modularmonolith.modules.payment.application.factory;

import com.victorxavier.modularmonolith.modules.payment.application.facade.PaymentFacade;
import com.victorxavier.modularmonolith.modules.payment.application.facade.PaymentFacadeInterface;
import com.victorxavier.modularmonolith.modules.payment.application.usecase.ProcessPaymentUseCase;
import com.victorxavier.modularmonolith.modules.payment.domain.gateway.ProcessPaymentGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentFacadeFactory {
    private final ProcessPaymentGateway paymentGateway;

    public PaymentFacadeFactory(ProcessPaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Bean
    public PaymentFacadeInterface createPaymentFacade() {
        ProcessPaymentUseCase processPaymentUseCase = new ProcessPaymentUseCase(paymentGateway);
        return new PaymentFacade(processPaymentUseCase);
    }
}
