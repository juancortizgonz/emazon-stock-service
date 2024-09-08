package com.emazon.stock_service.application.dto.item;

import com.emazon.stock_service.application.dto.BrandDto;
import com.emazon.stock_service.application.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {
    private String itemId;
    private String itemName;
    private String itemDescription;
    private Integer itemQuantity;
    private Double itemPrice;
    private BrandDto brandId;
    private List<CategoryDto> categoryIdList;
}
