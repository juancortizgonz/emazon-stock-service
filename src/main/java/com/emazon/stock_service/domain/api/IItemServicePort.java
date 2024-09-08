package com.emazon.stock_service.domain.api;

import com.emazon.stock_service.domain.model.Item;

public interface IItemServicePort {
    void saveItem(Item item);
}
