package com.emazon.stock_service.domain.usecase;

import com.emazon.stock_service.domain.api.IItemServicePort;
import com.emazon.stock_service.domain.model.CustomPagination;
import com.emazon.stock_service.domain.model.Item;
import com.emazon.stock_service.domain.spi.IItemPersistentPort;
import com.emazon.stock_service.domain.utils.PaginationInfo;

public class ItemUseCase implements IItemServicePort {
    private final IItemPersistentPort itemPersistentPort;

    public ItemUseCase(IItemPersistentPort itemPersistentPort) {
        this.itemPersistentPort = itemPersistentPort;
    }

    @Override
    public void saveItem(Item item) {
        itemPersistentPort.saveItem(item);
    }

    @Override
    public CustomPagination<Item> getAllItemsWithPagination(PaginationInfo paginationInfo) {
        return itemPersistentPort.getAllItemsWithPagination(paginationInfo);
    }
}
