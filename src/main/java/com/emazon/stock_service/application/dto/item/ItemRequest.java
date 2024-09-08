package com.emazon.stock_service.application.dto.item;

import com.emazon.stock_service.application.utils.ProductValidationConstants;
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

    @NotBlank(message = ProductValidationConstants.PRODUCT_NAME_IS_REQUIRED)
    private String itemName;

    @NotBlank(message = ProductValidationConstants.PRODUCT_DESCRIPTION_IS_REQUIRED)
    private String itemDescription;

    @NotNull(message = ProductValidationConstants.PRODUCT_QUANTITY_IS_REQUIRED)
    @Size(min = ProductValidationConstants.PRODUCT_QUANTITY_MIN_VALUE, max = ProductValidationConstants.PRODUCT_QUANTITY_MAX_VALUE, message = ProductValidationConstants.PRODUCT_QUANTITY_VALUE_MESSAGE)
    private Integer itemQuantity;

    @NotNull(message = ProductValidationConstants.PRODUCT_PRICE_IS_REQUIRED)
    @Min(value = ProductValidationConstants.PRODUCT_PRICE_MIN_VALUE, message = ProductValidationConstants.PRODUCT_PRICE_VALUE_MESSAGE)
    private Double itemPrice;

    @NotNull(message = ProductValidationConstants.PRODUCT_BRAND_IS_REQUIRED)
    @Positive(message = ProductValidationConstants.PRODUCT_BRAND_MUST_BE_POSITIVE)
    private Long brandId;

    @NotNull(message = ProductValidationConstants.PRODUCT_CATEGORY_ID_LIST_IS_REQUIRED)
    @Size(min = ProductValidationConstants.PRODUCT_CATEGORY_ID_LIST_MIN_SIZE, max = ProductValidationConstants.PRODUCT_CATEGORY_ID_LIST_MAX_SIZE)
    @UniqueElements(message = ProductValidationConstants.PRODUCT_CATEGORY_ID_LIST_UNIQUE_ELEMENTS_MESSAGE)
    private List<Long> categoryIdList;
}
