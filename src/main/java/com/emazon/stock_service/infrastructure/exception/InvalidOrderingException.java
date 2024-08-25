package com.emazon.stock_service.infrastructure.exception;

public class InvalidOrderingException extends RuntimeException {
    public InvalidOrderingException(String message) {
        super(message);
    }
}
