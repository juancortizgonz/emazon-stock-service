package com.emazon.stock_service.infrastructure.adapter;

import com.emazon.stock_service.domain.model.CustomPagination;
import com.emazon.stock_service.domain.model.Item;
import com.emazon.stock_service.domain.spi.IItemPersistentPort;
import com.emazon.stock_service.domain.utils.PaginationInfo;
import com.emazon.stock_service.domain.utils.SortArgument;
import com.emazon.stock_service.infrastructure.entity.ItemEntity;
import com.emazon.stock_service.infrastructure.mapper.IItemEntityMapper;
import com.emazon.stock_service.infrastructure.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

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
        PageRequest pageRequest = PageRequest.of(paginationInfo.getPageNumber(), paginationInfo.getPageSize());
        Page<ItemEntity> itemPage = null;

        if (Objects.equals(SortArgument.ITEM_NAME.getField(), paginationInfo.getSortBy())) {
            itemPage = paginationInfo.isAsc()
                    ? itemRepository.findAllOrderByItemNameAsc(pageRequest)
                    : itemRepository.findAllOrderByItemNameDesc(pageRequest);
        } else if (Objects.equals(SortArgument.BRAND_NAME.getField(), paginationInfo.getSortBy())) {
            itemPage = paginationInfo.isAsc()
                    ? itemRepository.findAllOrderByNameAsc(pageRequest)
                    : itemRepository.findAllOrderByNameDesc(pageRequest);
        } else if (Objects.equals(SortArgument.NUMBER_OF_CATEGORIES.getField(), paginationInfo.getSortBy())) {
            itemPage = paginationInfo.isAsc()
                    ? itemRepository.findAllOrderByNumberOfCategoryIdListAsc(pageRequest)
                    : itemRepository.findAllOrderByNumberOfCategoryIdListDesc(pageRequest);
        }

        assert itemPage != null;
        List<Item> items = itemEntityMapper.toItemList(itemPage.getContent());

        return new CustomPagination<>(
                items,
                itemPage.getTotalElements(),
                itemPage.getTotalPages(),
                paginationInfo.getPageNumber(),
                paginationInfo.isAsc()
        );
    }
}
