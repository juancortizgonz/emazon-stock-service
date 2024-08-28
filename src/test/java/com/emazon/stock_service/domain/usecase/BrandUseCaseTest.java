package com.emazon.stock_service.domain.usecase;

import com.emazon.stock_service.domain.model.Brand;
import com.emazon.stock_service.domain.spi.IBrandPersistentPort;
import com.emazon.stock_service.infrastructure.exception.BrandException;
import com.emazon.stock_service.infrastructure.exception.InvalidOrderingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BrandUseCaseTest {
    @Mock
    private IBrandPersistentPort brandPersistentPort;

    @InjectMocks
    private BrandUseCase brandUseCase;

    @Test
    @DisplayName("Given a valid brand it should be inserted into the database correctly.")
    void shouldInsertValidCategoryIntoDatabase() {
        Brand brand = new Brand(1L, "Category name", "Description.");
        doNothing().when(brandPersistentPort).saveBrand(brand);
        assertDoesNotThrow(() -> brandUseCase.saveBrand(brand));
        verify(brandPersistentPort).saveBrand(brand);
    }

    @Test
    @DisplayName("Given an invalid brand name, it should throw an exception.")
    void shouldThrowExceptionForInvalidNameBrand() {
        String invalidName = "A".repeat(51);
        Brand invalidBrand = new Brand(2L, invalidName, "Description.");
        assertThrows(BrandException.class, () -> brandUseCase.saveBrand(invalidBrand));
    }

    @Test
    @DisplayName("Given an invalid brand description, it should throw an exception.")
    void shouldThrowExceptionForInvalidDescriptionBrand() {
        String invalidDescription = "A".repeat(120);
        Brand invalidBrand = new Brand(3L, invalidDescription, "Description.");
        assertThrows(BrandException.class, () -> brandUseCase.saveBrand(invalidBrand));
    }

    @Test
    @DisplayName("It should return the brands paginated and sorted in ascending order")
    void shouldReturnBrandsOrderedAscending() {
        Brand brand1 = new Brand(4L, "Category A", "Description.");
        Brand brand2 = new Brand(5L, "Category B", "Description.");
        List<Brand> brands = Arrays.asList(brand1, brand2);
        when(brandPersistentPort.getBrands("asc")).thenReturn(brands);

        List<Brand> result = brandUseCase.getAllBrands("asc");
        assertEquals(2, result.size(), "The size of the result should be 2");
        assertEquals("Category A", result.get(0).getName(), "First category should be 'Category A'");
        assertEquals("Category B", result.get(1).getName(), "Second category should be 'Category B'");
    }

    @Test
    @DisplayName("Given an invalid order parameter, it should throw an InvalidOrderingException")
    void shouldThrowExceptionForInvalidOrderingParameter() {
        String invalidOrder = "invalid";
        assertThrows(InvalidOrderingException.class, () -> brandUseCase.getAllBrands(invalidOrder));
    }

    @Test
    @DisplayName("Given an empty order parameter, it should throw an InvalidOrderingException")
    void shouldThrowExceptionForEmptyOrderParameter() {
        String emptyOrder = "";
        assertThrows(InvalidOrderingException.class, () -> brandUseCase.getAllBrands(emptyOrder));
    }
}