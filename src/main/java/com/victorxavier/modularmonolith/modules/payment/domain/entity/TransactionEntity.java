package com.victorxavier.modularmonolith.modules.payment.domain.entity;

import com.victorxavier.modularmonolith.shared.domain.entity.BaseEntity;
import com.victorxavier.modularmonolith.shared.domain.valueobject.Id;
import java.util.UUID;
import java.time.LocalDateTime;

public class TransactionEntity extends BaseEntity {
    private final double amount;
    private final String orderId;
    private String status;

    public TransactionEntity(UUID id, double amount, String orderId, String status,
                             LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id);
        this.amount = amount;
        this.orderId = orderId;
        this.status = status != null ? status : "pending";
        validate();
    }

    public TransactionEntity(UUID id, double amount, String orderId) {
        this(id, amount, orderId, "pending", null, null);
    }

    public TransactionEntity(Id id, double amount, String orderId, String status,
                             LocalDateTime createdAt, LocalDateTime updatedAt) {
        this(id != null ? id.getValue() : null, amount, orderId, status, createdAt, updatedAt);
    }

    private void validate() {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be empty");
        }
    }

    public void approve() {
        this.status = "approved";
    }

    public void decline() {
        this.status = "declined";
    }

    public void process() {
        if (this.amount >= 100) {
            approve();
        } else {
            decline();
        }
    }

    public double getAmount() {
        return amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }
}




