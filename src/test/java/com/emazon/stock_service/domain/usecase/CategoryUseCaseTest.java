package com.emazon.stock_service.domain.usecase;

import com.emazon.stock_service.domain.model.Category;
import com.emazon.stock_service.domain.spi.ICategoryPersistentPort;
import com.emazon.stock_service.infrastructure.exception.CategoryException;
import com.emazon.stock_service.infrastructure.exception.InvalidOrderingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {
    @Mock
    private ICategoryPersistentPort categoryPersistentPort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @Test
    @DisplayName("Given a valid category it should be inserted into the database correctly.")
    void shouldInsertValidCategoryIntoDatabase() {
        Category category = new Category(1L, "Category name 1", "Category description.");
        doNothing().when(categoryPersistentPort).saveCategory(category);
        assertDoesNotThrow(() -> categoryUseCase.saveCategory(category));
        verify(categoryPersistentPort).saveCategory(category);
    }

    @Test
    @DisplayName("Given an invalid category name, it should throw an exception.")
    void shouldThrowExceptionForInvalidNameCategory() {
        String invalidName = "A".repeat(51);
        Category invalidCategory = new Category(2L, invalidName, "Valid description");
        assertThrows(CategoryException.class, () -> categoryUseCase.saveCategory(invalidCategory));
    }

    @Test
    @DisplayName("Given an invalid category description, it should throw an exception.")
    void shouldThrowExceptionForInvalidDescriptionCategory() {
        String invalidDescription = "A".repeat(91);
        Category invalidCategory = new Category(3L, "Valid name", invalidDescription);
        assertThrows(CategoryException.class, () -> categoryUseCase.saveCategory(invalidCategory));
    }

    @Test
    @DisplayName("It should return the categories paginated and sorted in ascending order")
    void shouldReturnCategoriesOrderedAscending() {
        Category category1 = new Category(4L, "Category A", "Description A.");
        Category category2 = new Category(5L, "Category B", "Description B.");
        List<Category> categories = Arrays.asList(category1, category2);
        when(categoryPersistentPort.getCategories("asc")).thenReturn(categories);

        List<Category> result = categoryUseCase.getAllCategories("asc");
        assertEquals(2, result.size(), "The size of the result should be 2");
        assertEquals("Category A", result.get(0).getName(), "First category should be 'Category A'");
        assertEquals("Category B", result.get(1).getName(), "Second category should be 'Category B'");
    }

    @Test
    @DisplayName("Given an invalid order parameter, it should throw an InvalidOrderingException")
    void shouldThrowExceptionForInvalidOrderingParameter() {
        String invalidOrder = "invalid";
        assertThrows(InvalidOrderingException.class, () -> categoryUseCase.getAllCategories(invalidOrder));
    }

    @Test
    @DisplayName("Given an empty order parameter, it should throw an InvalidOrderingException")
    void shouldThrowExceptionForEmptyOrderParameter() {
        String emptyOrder = "";
        assertThrows(InvalidOrderingException.class, () -> categoryUseCase.getAllCategories(emptyOrder));
    }
}