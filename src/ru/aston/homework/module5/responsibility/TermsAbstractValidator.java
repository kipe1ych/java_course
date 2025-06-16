package ru.aston.homework.module5.responsibility;

import java.util.Map;

/**
 * Валидатор согласия с условиями
 */
public class TermsAbstractValidator extends AbstractValidator {
    @Override
    public String handle(Map<String, String> data) {
        String agreeTerms = data.get("agree_terms");

        if (!agreeTerms.equals("true")) return "Вы должны принять условия пользования!";

        return super.handle(data);
    }
}
