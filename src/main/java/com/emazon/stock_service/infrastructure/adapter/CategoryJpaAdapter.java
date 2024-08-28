package com.emazon.stock_service.infrastructure.adapter;

import com.emazon.stock_service.domain.model.Category;
import com.emazon.stock_service.domain.spi.ICategoryPersistentPort;
import com.emazon.stock_service.infrastructure.exception.CategoryException;
import com.emazon.stock_service.infrastructure.mapper.ICategoryEntityMapper;
import com.emazon.stock_service.infrastructure.repository.CategoryRepository;
import com.emazon.stock_service.infrastructure.utils.PageCreator;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class CategoryJpaAdapter implements ICategoryPersistentPort {
    private final ICategoryEntityMapper categoryEntityMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public void saveCategory(Category category) {
        if (existsByName(category.getName())) {
            throw new CategoryException("The " + category.getName() + " category already exists in the database.");
        }
        categoryRepository.save(categoryEntityMapper.toCategoryEntity(category));
    }

    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public List<Category> getCategories(String order) {
        try {
            return categoryRepository.findAll(PageCreator.createPageable(order))
                    .map(categoryEntityMapper::toCategory)
                    .getContent();
        } catch (Exception e) {
            throw new CategoryException(e.getMessage());
        }
    }
}
