package com.lanchonete.api.adapters.driver.controller.exceptionHandler;

import com.lanchonete.api.infrastructure.exceptions.NotFoundException;
import com.lanchonete.api.infrastructure.exceptions.UniqueViolation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> entityNotFoundException(
            RuntimeException ex,
            HttpServletRequest request
    ){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(request.getRequestURI(), HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    @ExceptionHandler(UniqueViolation.class)
    public ResponseEntity<ErrorMessage> entityUniqueViolation(
            RuntimeException ex,
            HttpServletRequest request
    ){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorMessage(request.getRequestURI(), HttpStatus.CONFLICT.value(), ex.getMessage()));
    }
}
