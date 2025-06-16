package ru.aston.homework.module5.builder;

public class ConcreteOrderBuilder implements OrderBuilder {
    String product;
    int quantity;
    String deliveryMethod;
    String customerName;
    String customerEmail;
    String paymentMethod;

    @Override
    public OrderBuilder setProduct(String product) {
        this.product = product;

        return this;
    }

    @Override
    public OrderBuilder setQuantity(int quantity) {
        this.quantity = quantity;

        return this;
    }

    @Override
    public OrderBuilder setDeliveryMethod(String method) {
        this.deliveryMethod = method;

        return this;
    }

    @Override
    public OrderBuilder setCustomer(String name, String email) {
        this.customerName = name;
        this.customerEmail = email;

        return this;
    }

    @Override
    public OrderBuilder setCustomerEmail(String email) {
        this.customerEmail = email;

        return this;
    }

    @Override
    public OrderBuilder setPaymentMethod(String method) {
        this.paymentMethod = method;

        return this;
    }

    @Override
    public Order build() {
        return new Order(this);
    }
}