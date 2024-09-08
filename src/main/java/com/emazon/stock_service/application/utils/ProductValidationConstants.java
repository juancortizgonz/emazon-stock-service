package com.emazon.stock_service.application.utils;

public class ProductValidationConstants {
    private ProductValidationConstants() {
    }

    public static final int PRODUCT_QUANTITY_MIN_VALUE = 0;
    public static final int PRODUCT_QUANTITY_MAX_VALUE = 10000;
    public static final int PRODUCT_PRICE_MIN_VALUE = 0;
    public static final int PRODUCT_CATEGORY_ID_LIST_MIN_SIZE = 1;
    public static final int PRODUCT_CATEGORY_ID_LIST_MAX_SIZE = 3;

    public static final String PRODUCT_NAME_IS_REQUIRED = "Product name is required";
    public static final String PRODUCT_DESCRIPTION_IS_REQUIRED = "Product description is required";
    public static final String PRODUCT_QUANTITY_IS_REQUIRED = "Product quantity is required";
    public static final String PRODUCT_PRICE_IS_REQUIRED = "Product price is required";
    public static final String PRODUCT_BRAND_IS_REQUIRED = "Product brand is required";
    public static final String PRODUCT_CATEGORY_ID_LIST_IS_REQUIRED = "Product category Ids list is required";
    public static final String PRODUCT_QUANTITY_VALUE_MESSAGE = "Product quantity must be greater than or equal to " + PRODUCT_QUANTITY_MIN_VALUE + " and less than or equal to " + PRODUCT_QUANTITY_MAX_VALUE;
    public static final String PRODUCT_PRICE_VALUE_MESSAGE = "Product price must be greater than or equal to " + PRODUCT_PRICE_MIN_VALUE;
    public static final String PRODUCT_BRAND_MUST_BE_POSITIVE = "Product brand Id must be positive";
    public static final String PRODUCT_CATEGORY_ID_LIST_UNIQUE_ELEMENTS_MESSAGE = "Product category Ids list must contain unique elements";
}
