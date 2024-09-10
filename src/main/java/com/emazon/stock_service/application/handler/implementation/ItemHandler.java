package com.emazon.stock_service.application.handler.implementation;

import com.emazon.stock_service.application.dto.item.ItemRequest;
import com.emazon.stock_service.application.dto.item.ItemResponse;
import com.emazon.stock_service.application.handler.IItemHandler;
import com.emazon.stock_service.application.mapper.IBrandDtoMapper;
import com.emazon.stock_service.application.mapper.ICategoryDtoMapper;
import com.emazon.stock_service.application.mapper.item.IItemResponseMapper;
import com.emazon.stock_service.domain.api.IBrandServicePort;
import com.emazon.stock_service.domain.api.ICategoryServicePort;
import com.emazon.stock_service.domain.api.IItemServicePort;
import com.emazon.stock_service.domain.model.CustomPagination;
import com.emazon.stock_service.domain.model.Item;
import com.emazon.stock_service.domain.utils.PaginationInfo;
import com.emazon.stock_service.infrastructure.mapper.ICategoryEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemHandler implements IItemHandler {
    private final IItemServicePort itemServicePort;
    private final IItemResponseMapper itemResponseMapper;
    private final IBrandServicePort brandServicePort;
    private final IBrandDtoMapper brandDtoMapper;
    private final ICategoryDtoMapper categoryDtoMapper;
    private final ICategoryServicePort categoryServicePort;

    @Override
    public void saveItem(Item item) {
        itemServicePort.saveItem(item);
    }

    @Override
    public ResponseEntity<CustomPagination<ItemResponse>> getItemsWithPagination(int size, int page, String sortArgument, boolean isAsc) {
        CustomPagination<Item> itemCustomPagination = itemServicePort.getAllItemsWithPagination(new PaginationInfo(sortArgument, isAsc, size, page));
        List<Item> items = itemCustomPagination.getData();
        List<ItemResponse> itemResponses = items.stream().map(item -> {
            ItemResponse itemResponse = itemResponseMapper.toItemResponse(item);
            itemResponse.setBrandId(brandDtoMapper.toBrandDto(brandServicePort.getBrandById(item.getBrandId())));
            itemResponse.setCategoryIdList(categoryDtoMapper.toCategoryDtoList(categoryServicePort.getAllByItemId(item.getItemId())));
            return itemResponse;
        }).toList();

        return ResponseEntity.status(HttpStatus.OK).body(
                new CustomPagination<>(
                        itemResponses,
                        itemCustomPagination.getElements(),
                        itemCustomPagination.getPages(),
                        itemCustomPagination.getCurrentPage(),
                        itemCustomPagination.isAsc()
                )
        );
    }
}
