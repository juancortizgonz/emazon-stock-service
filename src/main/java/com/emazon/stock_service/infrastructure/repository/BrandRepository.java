package com.emazon.stock_service.infrastructure.repository;

import com.emazon.stock_service.infrastructure.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
    boolean existsByNameIgnoreCase(String name);
}
