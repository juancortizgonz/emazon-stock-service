package com.emazon.stock_service.domain.usecase;

import com.emazon.stock_service.domain.api.ICategoryServicePort;
import com.emazon.stock_service.domain.model.Category;
import com.emazon.stock_service.domain.spi.ICategoryPersistentPort;
import com.emazon.stock_service.domain.utils.ValidationUtils;
import com.emazon.stock_service.infrastructure.exception.CategoryException;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {
    private final ICategoryPersistentPort categoryPersistentPort;

    public CategoryUseCase(ICategoryPersistentPort categoryPersistentPort) {
        this.categoryPersistentPort = categoryPersistentPort;
    }

    private boolean validateCategory(Category category) {
        return category.getName().trim().length() < 50 && category.getDescription().trim().length() < 90;
    }

    @Override
    public void saveCategory(Category category) {
        if (!validateCategory(category)) {
            throw new CategoryException("One or more fields exceed the maximum length.\nMaximum name length: 50 characters.\nMaximum description length: 90 characters.");
        }
        categoryPersistentPort.saveCategory(category);
    }

    @Override
    public List<Category> getAllCategories(String order) {
        ValidationUtils.validateOrderString(order);
        return categoryPersistentPort.getCategories(order);
    }
}
