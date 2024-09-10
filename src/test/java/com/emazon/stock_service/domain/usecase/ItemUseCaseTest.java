package com.emazon.stock_service.domain.usecase;

import com.emazon.stock_service.domain.model.Brand;
import com.emazon.stock_service.domain.model.Category;
import com.emazon.stock_service.domain.model.Item;
import com.emazon.stock_service.domain.spi.IItemPersistentPort;
import com.emazon.stock_service.infrastructure.repository.BrandRepository;
import com.emazon.stock_service.infrastructure.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemUseCaseTest {
    @Mock
    private BrandRepository brandRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private IItemPersistentPort itemPersistentPort;

    @InjectMocks
    private ItemUseCase itemUseCase;

    @Test
    void shouldCreateItemWhenBrandAndCategoriesExist() {
        Brand brand = new Brand(1L, "Brand name", "Brand description");
        Category category = new Category(1L, "Category name", "Category description");
        List<Long> categories = new ArrayList<>(List.of(category.getId()));
        Item item = new Item(1L, "Item name", "Item description", 1, 2000.0, brand.getId(), categories);

        itemUseCase.saveItem(item);
        verify(itemPersistentPort, times(1)).saveItem(item);
    }

    @Test
    void shouldNotSaveItemWhenBrandDoesNotExist() {
        Category category = new Category(1L, "Category name", "Category description");
        List<Long> categories = new ArrayList<>(List.of(category.getId()));
        Item item = new Item(1L, "Item name", "Item description", 1, 2000.0, 2L, categories);

        verify(itemPersistentPort, never()).saveItem(item);
    }

    @Test
    void shouldNotSaveItemWhenCategoryDoesNotExist() {
        Brand brand = new Brand(1L, "Brand name", "Brand description");
        List<Long> categories = new ArrayList<>(List.of(1L));
        Item item = new Item(1L, "Item name", "Item description", 1, 2000.0, brand.getId(), categories);

        verify(itemPersistentPort, never()).saveItem(item);
    }
}