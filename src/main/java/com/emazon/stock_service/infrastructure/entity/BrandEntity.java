package com.emazon.stock_service.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long id;

    @Column(name = "brand_name", unique = true)
    private String name;

    @Column(name = "brand_description")
    private String description;

    @OneToMany(mappedBy = "brandId", fetch = FetchType.LAZY)
    private List<ItemEntity> items;
}
