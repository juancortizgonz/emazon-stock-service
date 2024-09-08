package com.emazon.stock_service.infrastructure.controller;

import com.emazon.stock_service.application.dto.item.ItemRequest;
import com.emazon.stock_service.application.handler.IItemHandler;
import com.emazon.stock_service.application.mapper.item.IItemRequestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/items")
@RequiredArgsConstructor
public class ItemController {
    private final IItemHandler itemHandler;
    private final IItemRequestMapper requestMapper;

    public void saveItem(@Valid @RequestBody ItemRequest itemRequest) {
        itemHandler.saveItem(requestMapper.toItem(itemRequest));
    }
}
