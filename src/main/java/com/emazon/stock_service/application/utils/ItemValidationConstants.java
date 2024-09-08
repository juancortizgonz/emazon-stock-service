package com.emazon.stock_service.application.utils;

public class ItemValidationConstants {
    private ItemValidationConstants() {
    }

    public static final int ITEM_QUANTITY_MIN_VALUE = 0;
    public static final int ITEM_QUANTITY_MAX_VALUE = 10000;
    public static final int ITEM_PRICE_MIN_VALUE = 0;
    public static final int ITEM_CATEGORY_ID_LIST_MIN_SIZE = 1;
    public static final int ITEM_CATEGORY_ID_LIST_MAX_SIZE = 3;

    public static final String ITEM_NAME_IS_REQUIRED = "Item name is required";
    public static final String ITEM_DESCRIPTION_IS_REQUIRED = "Item description is required";
    public static final String ITEM_QUANTITY_IS_REQUIRED = "Item quantity is required";
    public static final String ITEM_PRICE_IS_REQUIRED = "Item price is required";
    public static final String ITEM_BRAND_IS_REQUIRED = "Item brand is required";
    public static final String ITEM_CATEGORY_ID_LIST_IS_REQUIRED = "Item category Ids list is required";
    public static final String ITEM_QUANTITY_VALUE_MESSAGE = "Item quantity must be greater than or equal to " + ITEM_QUANTITY_MIN_VALUE + " and less than or equal to " + ITEM_QUANTITY_MAX_VALUE;
    public static final String ITEM_PRICE_VALUE_MESSAGE = "Item price must be greater than or equal to " + ITEM_PRICE_MIN_VALUE;
    public static final String ITEM_BRAND_MUST_BE_POSITIVE = "Item brand Id must be positive";
    public static final String ITEM_CATEGORY_ID_LIST_UNIQUE_ELEMENTS_MESSAGE = "Item category Ids list must contain unique elements";
}
