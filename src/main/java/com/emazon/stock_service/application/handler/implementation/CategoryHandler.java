package com.emazon.stock_service.application.handler.implementation;

import com.emazon.stock_service.application.dto.CategoryDto;
import com.emazon.stock_service.application.handler.ICategoryHandler;
import com.emazon.stock_service.application.mapper.ICategoryDtoMapper;
import com.emazon.stock_service.domain.api.ICategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryHandler implements ICategoryHandler {
    private final ICategoryServicePort categoryServicePort;
    private final ICategoryDtoMapper categoryDtoMapper;

    @Override
    public void saveCategory(CategoryDto category) {
        categoryServicePort.saveCategory(categoryDtoMapper.toCategory(category));
    }
}
