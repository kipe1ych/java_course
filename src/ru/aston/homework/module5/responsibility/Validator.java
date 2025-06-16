package ru.aston.homework.module5.responsibility;

import java.util.Map;

public interface Validator {
    /**
     * Устанавливает следующий обработчик в цепочке
     *
     * @param handler следующий обработчик
     * @return следующий обработчик
     */
    Validator setNext(Validator handler);

    /**
     * Обрабатывает данные формы
     *
     * @param data данные формы
     * @return сообщение об ошибке или null, если проверка пройдена
     */
    String handle(Map<String, String> data);
}
