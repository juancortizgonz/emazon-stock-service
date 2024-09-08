package com.emazon.stock_service.infrastructure.controller;

import com.emazon.stock_service.application.dto.item.ItemRequest;
import com.emazon.stock_service.application.handler.IItemHandler;
import com.emazon.stock_service.application.mapper.item.IItemRequestMapper;
import com.emazon.stock_service.infrastructure.utils.docs.ItemRestControllerConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
