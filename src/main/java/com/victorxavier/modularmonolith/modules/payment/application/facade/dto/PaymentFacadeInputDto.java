package com.victorxavier.modularmonolith.modules.payment.application.facade.dto;

public class PaymentFacadeInputDto {

    private String orderId;
    private double amount;

    public PaymentFacadeInputDto() {
    }

    public PaymentFacadeInputDto(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}