package com.emazon.stock_service.application.handler;

import com.emazon.stock_service.application.dto.BrandDto;
import org.springframework.data.domain.Page;

public interface IBrandHandler {
    void saveBrand(BrandDto brand);
    Page<BrandDto> getAllBrands(String order);
}
