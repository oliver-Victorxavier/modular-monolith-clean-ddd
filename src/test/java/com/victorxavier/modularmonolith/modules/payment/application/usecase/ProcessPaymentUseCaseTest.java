package com.victorxavier.modularmonolith.modules.payment.application.usecase;

import com.victorxavier.modularmonolith.modules.payment.application.dto.ProcessPaymentInputDto;
import com.victorxavier.modularmonolith.modules.payment.domain.entity.TransactionEntity;
import com.victorxavier.modularmonolith.modules.payment.domain.gateway.ProcessPaymentGateway;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProcessPaymentUseCaseTest {

    @Test
    void shouldProcessPaymentSuccessfully() {
        // Arrange
        ProcessPaymentGateway gateway = mock(ProcessPaymentGateway.class);
        ProcessPaymentUseCase useCase = new ProcessPaymentUseCase(gateway);

        ProcessPaymentInputDto input = new ProcessPaymentInputDto("order123", 50.0);

        TransactionEntity savedEntity = new TransactionEntity(
                UUID.randomUUID(), 50.0, "order123", "completed",
                java.time.LocalDateTime.now(), java.time.LocalDateTime.now()
        );

        when(gateway.save(any())).thenReturn(savedEntity);

        // Act
        var output = useCase.execute(input);

        // Assert
        assertNotNull(output.getTransactionId());
        assertEquals("order123", output.getOrderId());
        assertEquals(50.0, output.getAmount());
        assertEquals("completed", output.getStatus());
        verify(gateway, times(1)).save(any());
    }
    @Test
    void shouldCreateTransactionAndSaveToGateway() {
        var gateway = mock(ProcessPaymentGateway.class);
        var useCase = new ProcessPaymentUseCase(gateway);

        var input = new ProcessPaymentInputDto("order-abc", 75.0);

        var savedTransaction = new TransactionEntity(
                UUID.randomUUID(), 75.0, "order-abc", "completed",
                LocalDateTime.now(), LocalDateTime.now()
        );

        when(gateway.save(any())).thenReturn(savedTransaction);

        var output = useCase.execute(input);

        assertEquals("order-abc", output.getOrderId());
        assertEquals(75.0, output.getAmount());
        assertEquals("completed", output.getStatus());
        verify(gateway).save(any());
    }

}

