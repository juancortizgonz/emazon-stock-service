package com.emazon.stock_service.infrastructure.repository;

import com.emazon.stock_service.infrastructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByNameIgnoreCase(String name);
    Optional<CategoryEntity> findByNameIgnoreCase(String name);
}
