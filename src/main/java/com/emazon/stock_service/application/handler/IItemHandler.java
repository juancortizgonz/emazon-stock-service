package com.emazon.stock_service.application.handler;

import com.emazon.stock_service.application.dto.item.ItemResponse;
import com.emazon.stock_service.domain.model.CustomPagination;
import com.emazon.stock_service.domain.model.Item;
import org.springframework.http.ResponseEntity;

public interface IItemHandler {
    void saveItem(Item item);
    ResponseEntity<CustomPagination<ItemResponse>> getItemsWithPagination(int size, int page, String sortArgument, boolean isAsc);
}
