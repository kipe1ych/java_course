package ru.aston.homework.module5.adapter;

public class SberGateway implements Sber {
    @Override
    public String pay(double amount) {
        return "https://sber.ru/api?amount=" + amount;
    }
}
