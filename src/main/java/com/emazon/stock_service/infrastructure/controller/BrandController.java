package com.emazon.stock_service.infrastructure.controller;

import com.emazon.stock_service.application.dto.BrandDto;
import com.emazon.stock_service.application.handler.IBrandHandler;
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
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {
    private final IBrandHandler brandHandler;

    @Operation(summary = "Creates a new brand", description = "Creates a new brand from the data entered in the body")
    @ApiResponse(responseCode = "201", description = "Brand added successfully")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Brand object to be created", required = true, content = @Content(schema = @Schema(implementation = BrandDto.class)))
    @Tag(name = "Brand operations")
    @PostMapping
    public ResponseEntity<String> createBrand(@RequestBody BrandDto brandDto) {
        brandHandler.saveBrand(brandDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Brand " + brandDto.getName() + " added successfully");
    }

    @Operation(summary = "Gets all brands", description = "Gets all the brands and displays them paginated and sorted according to the parameter")
    @ApiResponse(responseCode = "200", description = "All brands have been obtained")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @Parameter(name = "order", description = "Order of elements: 'asc' or 'desc", required = true)
    @Tag(name = "Brand operations")
    @GetMapping
    public ResponseEntity<List<BrandDto>> getBrands(@RequestParam String order) {
        return ResponseEntity.status(HttpStatus.OK).body(brandHandler.getAllBrands(order).getContent());
    }
}
