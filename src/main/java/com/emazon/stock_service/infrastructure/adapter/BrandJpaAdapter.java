package com.emazon.stock_service.infrastructure.adapter;

import com.emazon.stock_service.domain.model.Brand;
import com.emazon.stock_service.domain.spi.IBrandPersistentPort;
import com.emazon.stock_service.infrastructure.exception.BrandException;
import com.emazon.stock_service.infrastructure.mapper.IBrandEntityMapper;
import com.emazon.stock_service.infrastructure.repository.BrandRepository;
import com.emazon.stock_service.infrastructure.utils.PageCreator;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class BrandJpaAdapter implements IBrandPersistentPort {
    private final IBrandEntityMapper brandEntityMapper;
    private final BrandRepository brandRepository;

    @Override
    public void saveBrand(Brand brand) {
        if (existsByName(brand.getName())) {
            throw new BrandException("The " + brand.getName() + " brand already exists in the database.");
        }
        brandRepository.save(brandEntityMapper.toBrandEntity(brand));
    }

    @Override
    public boolean existsByName(String name) {
        return brandRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public List<Brand> getBrands(String order) {
        try {
            return brandRepository.findAll(PageCreator.createPageable(order))
                    .map(brandEntityMapper::toBrand)
                    .getContent();
        } catch (Exception e) {
            throw new BrandException(e.getMessage());
        }
    }
}
