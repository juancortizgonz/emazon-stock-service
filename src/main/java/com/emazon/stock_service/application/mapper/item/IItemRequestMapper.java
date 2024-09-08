package com.emazon.stock_service.application.mapper.item;

import com.emazon.stock_service.application.dto.item.ItemRequest;
import com.emazon.stock_service.domain.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IItemRequestMapper {
    Item toItem(ItemRequest itemRequest);
}
