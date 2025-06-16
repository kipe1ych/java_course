package ru.aston.homework.module5.responsibility;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * Валидатор пароля
 */
public class PasswordAbstractValidator extends AbstractValidator {
    private static final Pattern LETTERS_PATTERN = Pattern.compile("[A-Za-z]");
    private static final Pattern DIGITS_PATTERN = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_CHARS_PATTERN = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]");

    @Override
    public String handle(Map<String, String> data) {
        String password = data.get("password");

        if (isNullOrEmpty(password)) return "Пароль не указан!";
        if (password.length() < 8) return "Пароль должен быть не менее 8 символов!";
        if (!LETTERS_PATTERN.matcher(password).find()) return "Пароль должен содержать буквы!";
        if (!DIGITS_PATTERN.matcher(password).find()) return "Пароль должен содержать цифры!";
        if (!SPECIAL_CHARS_PATTERN.matcher(password).find()) return "Пароль должен содержать спецсимволы!";

        return super.handle(data);
    }
}
