package com.victorxavier.modularmonolith.modules.payment.application.dto;

import java.time.LocalDateTime;

public class ProcessPaymentOutputDto {
    private String transactionId;
    private String orderId;
    private double amount;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProcessPaymentOutputDto(String transactionId, String orderId, double amount,
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
