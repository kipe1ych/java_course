package ru.aston.homework.module5.builder;

public interface OrderBuilder {
    OrderBuilder setProduct(String product);
    OrderBuilder setQuantity(int quantity);
    OrderBuilder setDeliveryMethod(String method);
    OrderBuilder setCustomer(String name, String email);
    OrderBuilder setCustomerEmail(String email);
    OrderBuilder setPaymentMethod(String method);
    Order build();
}