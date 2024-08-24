package com.emazon.stock_service.application.handler;

import com.emazon.stock_service.application.dto.CategoryDto;

public interface ICategoryHandler {
    void saveCategory(CategoryDto category);
}
