package com.emazon.stock_service.application.dto.item;

import com.emazon.stock_service.application.utils.ItemValidationConstants;
import com.emazon.stock_service.application.utils.docs.ItemRequestConstants;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = ItemRequestConstants.ITEM_REQUEST_DESCRIPTION)
public class ItemRequest implements Serializable {

    @Schema(description = ItemRequestConstants.ITEM_NAME_DESCRIPTION, example = ItemRequestConstants.ITEM_NAME_EXAMPLE)
    @NotBlank(message = ItemValidationConstants.ITEM_NAME_IS_REQUIRED)
    private String itemName;

    @Schema(description = ItemRequestConstants.ITEM_DESCRIPTION, example = ItemRequestConstants.ITEM_DESCRIPTION_EXAMPLE)
    @NotBlank(message = ItemValidationConstants.ITEM_DESCRIPTION_IS_REQUIRED)
    private String itemDescription;

    @Schema(description = ItemRequestConstants.ITEM_QUANTITY_DESCRIPTION, example = ItemRequestConstants.ITEM_QUANTITY_EXAMPLE)
    @NotNull(message = ItemValidationConstants.ITEM_QUANTITY_IS_REQUIRED)
    @Min(value = ItemValidationConstants.ITEM_QUANTITY_MIN_VALUE)
    @Max(value = ItemValidationConstants.ITEM_QUANTITY_MAX_VALUE)
    private Integer itemQuantity;

    @Schema(description = ItemRequestConstants.ITEM_PRICE_DESCRIPTION, example = ItemRequestConstants.ITEM_PRICE_EXAMPLE)
    @NotNull(message = ItemValidationConstants.ITEM_PRICE_IS_REQUIRED)
    @Min(value = ItemValidationConstants.ITEM_PRICE_MIN_VALUE, message = ItemValidationConstants.ITEM_PRICE_VALUE_MESSAGE)
    private Double itemPrice;

    @Schema(description = ItemRequestConstants.ITEM_BRAND_ID_DESCRIPTION, example = ItemRequestConstants.ITEM_BRAND_ID_EXAMPLE)
    @NotNull(message = ItemValidationConstants.ITEM_BRAND_IS_REQUIRED)
    @Positive(message = ItemValidationConstants.ITEM_BRAND_MUST_BE_POSITIVE)
    private Long brandId;

    @Schema(description = ItemRequestConstants.ITEM_CATEGORY_IDS_DESCRIPTION, example = ItemRequestConstants.ITEM_CATEGORY_IDS_EXAMPLE)
    @NotNull(message = ItemValidationConstants.ITEM_CATEGORY_ID_LIST_IS_REQUIRED)
    @Size(min = ItemValidationConstants.ITEM_CATEGORY_ID_LIST_MIN_SIZE, max = ItemValidationConstants.ITEM_CATEGORY_ID_LIST_MAX_SIZE)
    @UniqueElements(message = ItemValidationConstants.ITEM_CATEGORY_ID_LIST_UNIQUE_ELEMENTS_MESSAGE)
    private List<Long> categoryIdList;
}
