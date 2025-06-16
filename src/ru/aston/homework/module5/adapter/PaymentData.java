package ru.aston.homework.module5.adapter;

public class PaymentData {
    private final String paymentUrl;
    private final String paymentId;

    public PaymentData(String paymentUrl, String paymentId) {
        this.paymentUrl = paymentUrl;
        this.paymentId = paymentId;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public String getPaymentId() {
        return paymentId;
    }
}
