package com.emazon.stock_service.infrastructure.adapter;

import com.emazon.stock_service.domain.model.CustomPagination;
import com.emazon.stock_service.domain.model.Item;
import com.emazon.stock_service.domain.spi.IItemPersistentPort;
import com.emazon.stock_service.domain.utils.PaginationInfo;
import com.emazon.stock_service.infrastructure.mapper.IItemEntityMapper;
import com.emazon.stock_service.infrastructure.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemJpaAdapter implements IItemPersistentPort {
    private final IItemEntityMapper itemEntityMapper;
    private final ItemRepository itemRepository;

    @Override
    public void saveItem(Item item) {
        itemRepository.save(itemEntityMapper.toItemEntity(item));
    }

    @Override
    public CustomPagination<Item> getAllItemsWithPagination(PaginationInfo paginationInfo) {
        return null;
    }
}
