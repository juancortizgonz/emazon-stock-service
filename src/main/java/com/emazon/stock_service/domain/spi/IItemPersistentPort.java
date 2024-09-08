package com.emazon.stock_service.domain.spi;

import com.emazon.stock_service.domain.model.CustomPagination;
import com.emazon.stock_service.domain.model.Item;
import com.emazon.stock_service.domain.utils.PaginationInfo;

public interface IItemPersistentPort {
    void saveItem(Item item);
    CustomPagination<Item> getAllItemsWithPagination(PaginationInfo paginationInfo);
}
