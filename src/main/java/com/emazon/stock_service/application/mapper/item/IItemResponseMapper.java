package com.emazon.stock_service.application.mapper.item;

import com.emazon.stock_service.application.dto.BrandDto;
import com.emazon.stock_service.application.dto.CategoryDto;
import com.emazon.stock_service.application.dto.item.ItemResponse;
import com.emazon.stock_service.application.mapper.IBrandDtoMapper;
import com.emazon.stock_service.application.mapper.ICategoryDtoMapper;
import com.emazon.stock_service.domain.api.IBrandServicePort;
import com.emazon.stock_service.domain.model.Item;
import com.emazon.stock_service.domain.usecase.BrandUseCase;
import java.util.Collections;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        ICategoryDtoMapper.class,
        IBrandDtoMapper.class,
        IBrandServicePort.class
})
public interface IItemResponseMapper {
    @Mapping(source = "brandId", target = "brandId", qualifiedByName = "nullBrandDto")
    @Mapping(source = "categoryIdList", target = "categoryIdList", qualifiedByName = "nullCategoryDtoList")
    ItemResponse toItemResponse(Item item);

    @Named("nullBrandDto")
    default BrandDto nullBrandDto(Long brandId) {
        return null;
    }

    @Named("nullCategoryDtoList")
    default List<CategoryDto> nullCategoryDtoList(List<Long> categoryIdList) {
        return Collections.emptyList();
    }
}
