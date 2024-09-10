package com.emazon.stock_service.infrastructure.mapper;

import com.emazon.stock_service.domain.model.Item;
import com.emazon.stock_service.infrastructure.entity.BrandEntity;
import com.emazon.stock_service.infrastructure.entity.CategoryEntity;
import com.emazon.stock_service.infrastructure.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        ICategoryEntityMapper.class,
        IBrandEntityMapper.class,
})
public interface IItemEntityMapper {
    @Mapping(source = "brandId", target = "brandId", qualifiedByName = "idToBrand")
    @Mapping(source = "categoryIdList", target = "categoryIdList", qualifiedByName = "idToCategory")
    ItemEntity toItemEntity(Item item);

    @Mapping(source = "brandId", target = "brandId", qualifiedByName = "brandEntityToId")
    @Mapping(source = "categoryIdList", target = "categoryIdList", qualifiedByName = "categoryEntityListToLongList")
    Item toItem(ItemEntity itemEntity);

    @Mapping(source = "categoryIdList", target = "categoryIdList", qualifiedByName = "categoryEntityListToLongList")
    List<Item> toItemList(List<ItemEntity> itemEntityList);

    @Named("brandEntityToId")
    default Long brandEntityToId(BrandEntity brandEntity) {
        return brandEntity.getId();
    }

    @Named("categoryEntityListToLongList")
    default List<Long> categoryEntityListToLongList(List<CategoryEntity> categoryEntityList) {
        return categoryEntityList.stream().map(CategoryEntity::getId).toList();
    }

    @Named("idToCategory")
    default CategoryEntity idToCategory(Long categoryId) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryId);
        return categoryEntity;
    }
}
