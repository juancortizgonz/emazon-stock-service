package com.emazon.stock_service.infrastructure.repository;

import com.emazon.stock_service.infrastructure.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
