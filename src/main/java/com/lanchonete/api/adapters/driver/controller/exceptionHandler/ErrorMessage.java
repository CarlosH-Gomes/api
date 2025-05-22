package com.lanchonete.api.adapters.driver.controller.exceptionHandler;

public record ErrorMessage(
        String path,
        int statusCode,
        String errorMessage
) {
}
