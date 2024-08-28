package com.emazon.stock_service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ExceptionResDto {
    private String errorTitle;
    private String errorMessage;
    private HttpStatus httpStatus;
}
