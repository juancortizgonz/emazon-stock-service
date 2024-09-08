package com.emazon.stock_service.application.handler;

import com.emazon.stock_service.domain.model.Item;

public interface IItemHandler {
    void saveItem(Item item);
}
