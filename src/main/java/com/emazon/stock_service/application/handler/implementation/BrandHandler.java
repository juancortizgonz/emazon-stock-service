package com.emazon.stock_service.application.handler.implementation;

import com.emazon.stock_service.application.dto.BrandDto;
import com.emazon.stock_service.application.handler.IBrandHandler;
import com.emazon.stock_service.application.mapper.IBrandDtoMapper;
import com.emazon.stock_service.application.utils.ListConverter;
import com.emazon.stock_service.domain.api.IBrandServicePort;
import com.emazon.stock_service.domain.model.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BrandHandler implements IBrandHandler {
    private final IBrandServicePort brandService;
    private final IBrandDtoMapper brandDtoMapper;

    public void saveBrand(BrandDto brand) {
        brandService.saveBrand(brandDtoMapper.toBrand(brand));
    }

    public Page<BrandDto> getAllBrands(String order) {
        return ListConverter.listToPage(convertList(brandService.getAllBrands(order)), null, null);
    }

    private List<BrandDto> convertList(List<Brand> brands) {
        if (brands == null || brands.isEmpty()) {
            return Collections.emptyList();
        }

        return brands.stream()
                .map(brandDtoMapper::toBrandDto)
                .toList();
    }
}
