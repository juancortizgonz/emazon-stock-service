package com.emazon.stock_service.infrastructure.controller;

import com.emazon.stock_service.application.dto.CategoryDto;
import com.emazon.stock_service.application.handler.ICategoryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @Operation(summary = "Creates a new category", description = "Creates a new category from the data entered in the body")
    @ApiResponse(responseCode = "201", description = "Category added successfully")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Category object to be created", required = true, content = @Content(schema = @Schema(implementation = CategoryDto.class)))
    @Tag(name = "Category operations")
    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody CategoryDto categoryDto) {
        categoryHandler.saveCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("The " + categoryDto.getName() + " category has been created");
    }

    @Operation(summary = "Gets all categories", description = "Gets all the categories and displays them paginated and sorted according to the parameter")
    @ApiResponse(responseCode = "200", description = "All categories have been obtained")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @Parameter(name = "order", description = "Order of elements: 'asc' or 'desc", required = true)
    @Tag(name = "Category operations")
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories(@RequestParam String order) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryHandler.getAllCategories(order).getContent());
    }
}
