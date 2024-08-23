package com.emazon.stock_service.application.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    @NotEmpty(message = "Category name cannot be empty")
    @Size(max = 50, message = "Category name's length cannot be longer than 50")
    private String name;

    @NotEmpty(message = "Category description cannot be empty")
    @Size(max = 90, message = "Category description's length cannot be longer than 90")
    private String description;
}
