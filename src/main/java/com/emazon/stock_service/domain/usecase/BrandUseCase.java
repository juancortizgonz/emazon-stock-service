package com.emazon.stock_service.domain.usecase;

import com.emazon.stock_service.domain.api.IBrandServicePort;
import com.emazon.stock_service.domain.model.Brand;
import com.emazon.stock_service.domain.spi.IBrandPersistentPort;
import com.emazon.stock_service.domain.utils.ValidationUtils;
import com.emazon.stock_service.infrastructure.exception.BrandException;

import java.util.List;

public class BrandUseCase implements IBrandServicePort {
    private final IBrandPersistentPort brandPersistentPort;

    public BrandUseCase(IBrandPersistentPort brandPersistentPort) {
        this.brandPersistentPort = brandPersistentPort;
    }

    private boolean validateBrand(Brand brand) {
        return brand.getName().trim().length() < 50 && brand.getDescription().trim().length() < 120 && !brand.getDescription().isBlank();
    }

    @Override
    public void saveBrand(Brand brand) {
        if (!validateBrand(brand)) {
            throw new BrandException("One or more fields are invalid.");
        }
        brandPersistentPort.saveBrand(brand);
    }

    @Override
    public List<Brand> getAllBrands(String order) {
        ValidationUtils.validateOrderString(order);
        return brandPersistentPort.getBrands(order);
    }

    @Override
    public Brand getBrandById(Long brandId) {
        return brandPersistentPort.getBrandById(brandId);
    }
}
