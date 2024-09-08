package com.emazon.stock_service.domain.spi;

import com.emazon.stock_service.domain.model.Item;

public interface IItemPersistentPort {
    void saveItem(Item item);
}
