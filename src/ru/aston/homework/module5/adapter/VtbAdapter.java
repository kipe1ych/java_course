package ru.aston.homework.module5.adapter;

public class VtbAdapter implements Sber {
    private final VtbGateway vtb;

    public VtbAdapter(VtbGateway vtb) {
        this.vtb = vtb;
    }

    @Override
    public String pay(double amount) {
        PaymentData response = vtb.initPayment(amount);
        return response.getPaymentUrl();
    }
}
