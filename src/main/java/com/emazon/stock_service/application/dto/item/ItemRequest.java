package com.emazon.stock_service.application.dto.item;

import com.emazon.stock_service.application.utils.ItemValidationConstants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest implements Serializable {

    @NotBlank(message = ItemValidationConstants.ITEM_NAME_IS_REQUIRED)
    private String itemName;

    @NotBlank(message = ItemValidationConstants.ITEM_DESCRIPTION_IS_REQUIRED)
    private String itemDescription;

    @NotNull(message = ItemValidationConstants.ITEM_QUANTITY_IS_REQUIRED)
    @Min(value = ItemValidationConstants.ITEM_QUANTITY_MIN_VALUE)
    @Max(value = ItemValidationConstants.ITEM_QUANTITY_MAX_VALUE)
    private Integer itemQuantity;

    @NotNull(message = ItemValidationConstants.ITEM_PRICE_IS_REQUIRED)
    @Min(value = ItemValidationConstants.ITEM_PRICE_MIN_VALUE, message = ItemValidationConstants.ITEM_PRICE_VALUE_MESSAGE)
    private Double itemPrice;

    @NotNull(message = ItemValidationConstants.ITEM_BRAND_IS_REQUIRED)
    @Positive(message = ItemValidationConstants.ITEM_BRAND_MUST_BE_POSITIVE)
    private Long brandId;

    @NotNull(message = ItemValidationConstants.ITEM_CATEGORY_ID_LIST_IS_REQUIRED)
    @Size(min = ItemValidationConstants.ITEM_CATEGORY_ID_LIST_MIN_SIZE, max = ItemValidationConstants.ITEM_CATEGORY_ID_LIST_MAX_SIZE)
    @UniqueElements(message = ItemValidationConstants.ITEM_CATEGORY_ID_LIST_UNIQUE_ELEMENTS_MESSAGE)
    private List<Long> categoryIdList;
}
