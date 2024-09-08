package com.emazon.stock_service.infrastructure.entity;

import com.emazon.stock_service.infrastructure.utils.ItemEntityConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ItemEntityConstants.ITEM_TABLE_NAME)
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ItemEntityConstants.ITEM_ID_COLUMN)
    private Long itemId;

    @Column(name = ItemEntityConstants.ITEM_NAME_COLUMN, nullable = false, length = ItemEntityConstants.ITEM_NAME_LENGTH)
    private String itemName;

    @Column(name = ItemEntityConstants.ITEM_DESCRIPTION_COLUMN, nullable = false, length = ItemEntityConstants.ITEM_DESCRIPTION_LENGTH)
    private String itemDescription;

    @Column(name = ItemEntityConstants.ITEM_QUANTITY_COLUMN, nullable = false)
    private Integer itemQuantity;

    @Column(name = ItemEntityConstants.ITEM_PRICE_COLUMN, nullable = false)
    private Double itemPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ItemEntityConstants.JOIN_BRAND_ID)
    private BrandEntity brandId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = ItemEntityConstants.JOIN_TABLE_ITEM_CATEGORY,
        joinColumns = @JoinColumn(name = ItemEntityConstants.JOIN_ITEM_ID),
        inverseJoinColumns = @JoinColumn(name = ItemEntityConstants.JOIN_CATEGORY_LIST))
    private List<CategoryEntity> categoryIdList;
}
