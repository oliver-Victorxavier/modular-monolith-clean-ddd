package com.victorxavier.modularmonolith.modules.payment.application.facade.dto;


import java.time.LocalDateTime;

public class PaymentFacadeOutputDto {
    private final String transactionId;
    private final String orderId;
    private final double amount;
    private final String status;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public PaymentFacadeOutputDto(String transactionId, String orderId, double amount,
                                  String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}