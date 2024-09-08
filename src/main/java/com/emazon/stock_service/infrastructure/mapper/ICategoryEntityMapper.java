package com.emazon.stock_service.infrastructure.mapper;

import com.emazon.stock_service.domain.model.Category;
import com.emazon.stock_service.infrastructure.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryEntityMapper {
    @Mapping(target = "name", source = "name")
    CategoryEntity toCategoryEntity(Category category);

    @Mapping(target = "name", source = "name")
    Category toCategory(CategoryEntity categoryEntity);

    List<Category> toCategoryList(List<CategoryEntity> categoryEntityList);
}
