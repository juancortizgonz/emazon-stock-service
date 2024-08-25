package com.emazon.stock_service.infrastructure.controller;

import com.emazon.stock_service.application.dto.CategoryDto;
import com.emazon.stock_service.application.handler.ICategoryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryHandler categoryHandler;

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody CategoryDto categoryDto) {
        categoryHandler.saveCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("The " + categoryDto.getName() + " category has been created");
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories(@RequestParam String order) {
        return ResponseEntity.status(HttpStatus.FOUND).body(categoryHandler.getAllCategories(order).getContent());
    }
}
