package com.emazon.stock_service.domain.spi;

import com.emazon.stock_service.domain.model.Brand;

import java.util.List;

public interface IBrandPersistentPort {
    void saveBrand(Brand brand);
    boolean existsByName(String name);
    List<Brand> getBrands(String order);
}
