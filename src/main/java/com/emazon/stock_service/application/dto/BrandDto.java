package com.emazon.stock_service.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Brand Data Transfer Object")
public class BrandDto {
    @NotEmpty(message = "Brand name cannot be empty")
    @Size(max = 50, message = "Brand name's length cannot be longer than 50")
    private String name;

    @NotEmpty(message = "Brand description cannot be empty")
    @Size(max = 120, message = "Brand name's length cannot be longer than 120")
    private String description;
}
