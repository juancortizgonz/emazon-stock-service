package com.emazon.stock_service.application.handler.implementation;

import com.emazon.stock_service.application.dto.CategoryDto;
import com.emazon.stock_service.application.handler.ICategoryHandler;
import com.emazon.stock_service.application.mapper.ICategoryDtoMapper;
import com.emazon.stock_service.application.utils.ListConverter;
import com.emazon.stock_service.domain.api.ICategoryServicePort;
import com.emazon.stock_service.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryHandler implements ICategoryHandler {
    private final ICategoryServicePort categoryServicePort;
    private final ICategoryDtoMapper categoryDtoMapper;

    @Override
    public void saveCategory(CategoryDto category) {
        categoryServicePort.saveCategory(categoryDtoMapper.toCategory(category));
    }

    @Override
    public Page<CategoryDto> getAllCategories(String order) {
        return ListConverter.listToPage(convertList(categoryServicePort.getAllCategories(order)), null, null);
    }

    private List<CategoryDto> convertList(List<Category> categories) {
        if (categories == null || categories.isEmpty()) {
            return Collections.emptyList();
        }

        return categories.stream()
                .map(categoryDtoMapper::toCategoryDto)
                .toList();
    }
}
