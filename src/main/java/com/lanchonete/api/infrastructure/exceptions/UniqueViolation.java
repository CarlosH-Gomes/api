package com.lanchonete.api.infrastructure.exceptions;

public class UniqueViolation extends RuntimeException {
    public UniqueViolation(String message) {
        super(message);
    }
}
