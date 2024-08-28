package com.emazon.stock_service.infrastructure.config;

import com.emazon.stock_service.application.dto.ExceptionResDto;
import com.emazon.stock_service.infrastructure.exception.CategoryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryException.class)
    public ResponseEntity<ExceptionResDto> handleCategoryException(CategoryException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResDto("Category Exception", exception.getMessage(), HttpStatus.BAD_REQUEST));
    }
}
