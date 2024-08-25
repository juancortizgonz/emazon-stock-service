package com.emazon.stock_service.domain.utils;

import com.emazon.stock_service.infrastructure.exception.InvalidOrderingException;

public class ValidationUtils {
    private ValidationUtils() {
        throw new AssertionError("Cannot instantiate utility class");
    }

    public static void validateOrderString(String orderString) {
        if (!"asc".equalsIgnoreCase(orderString) && !"desc".equalsIgnoreCase(orderString)) {
            throw new InvalidOrderingException(orderString + " is not a valid order. Choose 'asc' or 'desc'");
        }
    }
}
