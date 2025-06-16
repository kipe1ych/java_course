package ru.aston.homework.module5.builder;

public class OrderDirector {
    /**
     * Создаёт стандартный заказ
     */
    public Order buildDefaultOrder(OrderBuilder builder) {
        return builder
                .setProduct("Ноутбук")
                .setQuantity(1)
                .setDeliveryMethod("курьер")
                .setCustomer("Иван", "ivan@example.com")
                .setPaymentMethod("карта")
                .build();
    }

    /**
     * Создаёт минимальный заказ
     */
    public Order buildMinimalOrder(OrderBuilder builder, String product, String email) {
        return builder
                .setProduct(product)
                .setQuantity(1)
                .setCustomerEmail(email)
                .build();
    }
}