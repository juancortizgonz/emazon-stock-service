package com.emazon.stock_service.application.handler.implementation;

import com.emazon.stock_service.application.handler.IItemHandler;
import com.emazon.stock_service.domain.api.IItemServicePort;
import com.emazon.stock_service.domain.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemHandler implements IItemHandler {
    private final IItemServicePort itemServicePort;

    @Override
    public void saveItem(Item item) {
        itemServicePort.saveItem(item);
    }
}
