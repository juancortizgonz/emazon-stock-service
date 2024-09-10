package com.emazon.stock_service.infrastructure.repository;

import com.emazon.stock_service.infrastructure.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
    // ASC
    @Query("SELECT i FROM ItemEntity i ORDER BY i.itemName ASC")
    Page<ItemEntity> findAllOrderByItemNameAsc(Pageable pageable);

    @Query("SELECT i FROM ItemEntity i JOIN i.brandId b ORDER BY b.name ASC")
    Page<ItemEntity> findAllOrderByNameAsc(Pageable pageable);

    @Query("SELECT i FROM ItemEntity i LEFT JOIN i.categoryIdList c " +
            "GROUP BY i.itemId " +
            "ORDER BY COUNT(c.id) ASC, MIN(c.name) ASC")
    Page<ItemEntity> findAllOrderByNumberOfCategoryIdListAsc(Pageable pageable);

    // DESC
    @Query("SELECT i FROM ItemEntity i ORDER BY i.itemName DESC")
    Page<ItemEntity> findAllOrderByItemNameDesc(Pageable pageable);

    @Query("SELECT i FROM ItemEntity i JOIN i.brandId b ORDER BY b.name DESC")
    Page<ItemEntity> findAllOrderByNameDesc(Pageable pageable);

    @Query("SELECT i FROM ItemEntity i LEFT JOIN i.categoryIdList c " +
            "GROUP BY i.itemId " +
            "ORDER BY COUNT(c.id) DESC, MIN(c.name) ASC")
    Page<ItemEntity> findAllOrderByNumberOfCategoryIdListDesc(Pageable pageable);
}
