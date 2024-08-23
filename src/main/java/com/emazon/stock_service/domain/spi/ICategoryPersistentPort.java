package com.emazon.stock_service.domain.spi;

import com.emazon.stock_service.domain.model.Category;

public interface ICategoryPersistentPort {
    void saveCategory(Category category);
}
