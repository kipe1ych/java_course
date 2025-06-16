package ru.aston.homework.module5.responsibility;

import java.util.Map;

public abstract class AbstractValidator implements Validator {
    private Validator nextHandler;

    @Override
    public Validator setNext(Validator handler) {
        this.nextHandler = handler;

        return handler;
    }

    @Override
    public String handle(Map<String, String> data) {
        if (nextHandler != null) return nextHandler.handle(data);

        return null;
    }

    /**
     * Проверяет наличие значения
     *
     * @param value значение для проверки
     * @return true если значение существует и не пустое
     */
    protected boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
