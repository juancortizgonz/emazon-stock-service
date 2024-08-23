package com.emazon.stock_service.domain.usecase;

import com.emazon.stock_service.domain.api.ICategoryServicePort;
import com.emazon.stock_service.domain.model.Category;
import com.emazon.stock_service.domain.spi.ICategoryPersistentPort;

public class CategoryUseCase implements ICategoryServicePort {
    private final ICategoryPersistentPort categoryPersistentPort;

    public CategoryUseCase(ICategoryPersistentPort categoryPersistentPort) {
        this.categoryPersistentPort = categoryPersistentPort;
    }

    @Override
    public void saveCategory(Category category) {
        categoryPersistentPort.saveCategory(category);
    }
}
