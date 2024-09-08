package com.emazon.stock_service.infrastructure.repository;

import com.emazon.stock_service.infrastructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByNameIgnoreCase(String name);
    Optional<CategoryEntity> findByNameIgnoreCase(String name);

    @Query("SELECT c FROM CategoryEntity c JOIN c.items i WHERE i.itemId = :itemId ORDER BY c.name ASC")
    List<CategoryEntity> findCategoriesByItemId(
            @Param("itemId") Long itemId
    );
}
