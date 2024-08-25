package com.emazon.stock_service.domain.spi;

import com.emazon.stock_service.domain.model.Category;

import java.util.List;

public interface ICategoryPersistentPort {
    void saveCategory(Category category);
    boolean existsByName(String name);
    List<Category> getCategories(String order);
}
