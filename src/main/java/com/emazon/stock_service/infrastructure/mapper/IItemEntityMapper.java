package com.emazon.stock_service.infrastructure.mapper;

import com.emazon.stock_service.domain.model.Item;
import com.emazon.stock_service.infrastructure.entity.CategoryEntity;
import com.emazon.stock_service.infrastructure.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {
        ICategoryEntityMapper.class,
        IBrandEntityMapper.class,
})
public interface IItemEntityMapper {
    @Mapping(source = "brandId", target = "brandId", qualifiedByName = "idToBrand")
    @Mapping(source = "categoryIdList", target = "categoryIdList", qualifiedByName = "idToCategory")
    ItemEntity toItemEntity(Item item);

    @Named("idToCategory")
    default CategoryEntity idToCategory(Long categoryId) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryId);
        return categoryEntity;
    }
}
