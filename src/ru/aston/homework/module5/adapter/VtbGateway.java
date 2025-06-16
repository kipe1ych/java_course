package ru.aston.homework.module5.adapter;

import java.util.UUID;

public class VtbGateway {
    /**
     * платеж в ВТБ
     *
     * @param amountRub сумма
     * @return объект с данными платежа
     */
    public PaymentData initPayment(double amountRub) {
        String paymentUrl = "https://vtb.ru/api?amount=" + amountRub;
        String paymentId = UUID.randomUUID().toString();

        return new PaymentData(paymentUrl, paymentId);
    }
}
