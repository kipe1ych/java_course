package ru.aston.homework.module5.builder;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String product;
    private final int quantity;
    private final String deliveryMethod;
    private final String customerName;
    private final String customerEmail;
    private final String paymentMethod;

    Order(ConcreteOrderBuilder builder) {
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.deliveryMethod = builder.deliveryMethod;
        this.customerName = builder.customerName;
        this.customerEmail = builder.customerEmail;
        this.paymentMethod = builder.paymentMethod;
    }

    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public String getDeliveryMethod() { return deliveryMethod; }
    public String getCustomerName() { return customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public String getPaymentMethod() { return paymentMethod; }

    /**
     * Выполняет валидацию данных заказа.
     *
     * @return список ошибок
     */
    public List<String> validate() {
        List<String> errors = new ArrayList<>();
        if (product == null || product.isEmpty()) errors.add("Не выбран товар");
        if (quantity <= 0) errors.add("Неверное количество");
        if (customerEmail == null || customerEmail.isEmpty()) errors.add("Email обязателен");

        return errors;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}