package ru.aston.homework.module5.adapter;

public interface Sber {
    /**
     * Выполняет платеж через Sber
     *
     * @param amount сумма платежа
     * @return URL для перенаправления на страницу оплаты
     */
    String pay(double amount);
}