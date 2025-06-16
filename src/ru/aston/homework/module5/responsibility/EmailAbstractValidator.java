package ru.aston.homework.module5.responsibility;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * Валидатор email
 */
public class EmailAbstractValidator extends AbstractValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    @Override
    public String handle(Map<String, String> data) {
        String email = data.get("email");

        if (isNullOrEmpty(email)) return "Email не указан!";
        if (!EMAIL_PATTERN.matcher(email).matches()) return "Некорректный email!";

        return super.handle(data);
    }
}
