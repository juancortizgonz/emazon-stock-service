package com.emazon.stock_service.infrastructure.adapter;

import com.emazon.stock_service.domain.model.Category;
import com.emazon.stock_service.domain.spi.ICategoryPersistentPort;
import com.emazon.stock_service.infrastructure.mapper.ICategoryEntityMapper;
import com.emazon.stock_service.infrastructure.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CategoryJpaAdapter implements ICategoryPersistentPort {
    private final ICategoryEntityMapper categoryEntityMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(categoryEntityMapper.toCategoryEntity(category));
    }
}
