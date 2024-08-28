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
@Schema(description = "Category Data Transfer Object")
public class CategoryDto {

    @Schema(description = "Category name. Must be unique and cannot exceed 50 characters.")
    @NotEmpty(message = "Category name cannot be empty")
    @Size(max = 50, message = "Category name's length cannot be longer than 50")
    private String name;

    @Schema(description = "Category description. Cannot exceed 50 characters.")
    @NotEmpty(message = "Category description cannot be empty")
    @Size(max = 90, message = "Category description's length cannot be longer than 90")
    private String description;
}
