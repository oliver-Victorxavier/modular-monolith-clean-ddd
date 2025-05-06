package com.victorxavier.modularmonolith.modules.payment.application.facade;

import com.victorxavier.modularmonolith.modules.payment.application.dto.ProcessPaymentOutputDto;
import com.victorxavier.modularmonolith.modules.payment.application.facade.dto.PaymentFacadeInputDto;
import com.victorxavier.modularmonolith.modules.payment.application.usecase.ProcessPaymentUseCase;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PaymentFacadeTest {

    @Test
    void shouldDelegateToUseCaseAndReturnExpectedOutput() {
        // Arrange
        ProcessPaymentUseCase useCase = mock(ProcessPaymentUseCase.class);
        PaymentFacade facade = new PaymentFacade(useCase);

        PaymentFacadeInputDto input = new PaymentFacadeInputDto("order456", 100.0);

        ProcessPaymentOutputDto useCaseOutput = new ProcessPaymentOutputDto(
                "tx456", "order456", 100.0, "completed",
                LocalDateTime.now(), LocalDateTime.now()
        );

        when(useCase.execute(any())).thenReturn(useCaseOutput);

        // Act
        var output = facade.process(input);

        // Assert
        assertEquals("tx456", output.getTransactionId());
        assertEquals("order456", output.getOrderId());
        assertEquals(100.0, output.getAmount());
        assertEquals("completed", output.getStatus());
        verify(useCase, times(1)).execute(any());
    }

    @Test
    void shouldCallUseCaseAndReturnOutput() {
        var useCase = mock(ProcessPaymentUseCase.class);
        var facade = new PaymentFacade(useCase);

        var input = new PaymentFacadeInputDto("order-xyz", 99.9);
        var outputFromUseCase = new ProcessPaymentOutputDto(
                "tx-id", "order-xyz", 99.9, "completed",
                LocalDateTime.now(), LocalDateTime.now()
        );

        when(useCase.execute(any())).thenReturn(outputFromUseCase);

        var output = facade.process(input);

        assertEquals("order-xyz", output.getOrderId());
        assertEquals(99.9, output.getAmount());
        verify(useCase).execute(any());
    }

}
