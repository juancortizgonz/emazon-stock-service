package com.emazon.stock_service.application.handler;

import com.emazon.stock_service.application.dto.CategoryDto;
import org.springframework.data.domain.Page;

public interface ICategoryHandler {
    void saveCategory(CategoryDto category);
    Page<CategoryDto> getAllCategories(String order);
}
