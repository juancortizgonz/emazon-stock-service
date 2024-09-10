package com.emazon.stock_service.infrastructure.controller;

import com.emazon.stock_service.application.dto.item.ItemRequest;
import com.emazon.stock_service.application.dto.item.ItemResponse;
import com.emazon.stock_service.application.handler.IItemHandler;
import com.emazon.stock_service.application.mapper.item.IItemRequestMapper;
import com.emazon.stock_service.domain.model.CustomPagination;
import com.emazon.stock_service.infrastructure.utils.docs.ItemRestControllerConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
@Tag(name = ItemRestControllerConstants.TAG_NAME, description = ItemRestControllerConstants.TAG_DESCRIPTION)
public class ItemController {
    private final IItemHandler itemHandler;
    private final IItemRequestMapper requestMapper;

    @Operation(summary = ItemRestControllerConstants.SAVE_ITEM_NAME, description = ItemRestControllerConstants.SAVE_ITEM_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = ItemRestControllerConstants.SAVE_ITEM_RESPONSE_CREATED_DESCRIPTION),
            @ApiResponse(responseCode = "400", description = ItemRestControllerConstants.SAVE_ITEM_RESPONSE_BAD_REQUEST_DESCRIPTION)
    })
    @PostMapping
    public void saveItem(
            @Parameter(description = ItemRestControllerConstants.ITEM_BODY_DESCRIPTION,
                    required = true)
            @Valid @RequestBody ItemRequest itemRequest) {
        itemHandler.saveItem(requestMapper.toItem(itemRequest));
    }

    @GetMapping
    public ResponseEntity<CustomPagination<ItemResponse>> getItemsWithPagination(
            @RequestParam(defaultValue = "itemName", required = false) String sortArgument,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size,
            @RequestParam(defaultValue = "true", required = false) boolean isAsc
    ) {
        return itemHandler.getItemsWithPagination(size, page, sortArgument, isAsc);
    }
}
