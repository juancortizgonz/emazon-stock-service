package com.emazon.stock_service.application.mapper;

import com.emazon.stock_service.application.dto.CategoryDto;
import com.emazon.stock_service.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryDtoMapper {
    @Mapping(target = "name", source = "name")
    Category toCategory(CategoryDto categoryDto);

    @Mapping(target = "name", source = "name")
    CategoryDto toCategoryDto(Category category);

    List<CategoryDto> toCategoryDtoList(List<Category> categories);
}
