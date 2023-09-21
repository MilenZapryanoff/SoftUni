package com.example.jsonprocessing_exercise.util;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface ValidationUtil {
    //ако искаме единствено да проверим дали данните са валидни БЕЗ да връщаме/печатаме съобщения за грешки
    <E> boolean isValid(E entity);

    //ако искаме единствено да проверим дали данните са валидни И да връщаме/печатаме съобщения за грешки
    <E> Set<ConstraintViolation<E>> getViolations(E entity);
}
