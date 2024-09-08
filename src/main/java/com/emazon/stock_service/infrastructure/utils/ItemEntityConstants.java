package com.emazon.stock_service.infrastructure.utils;

public class ItemEntityConstants {
    private ItemEntityConstants() {
    }

    public static final String ITEM_TABLE_NAME = "item";
    public static final String ITEM_ID_COLUMN = "item_id";
    public static final String ITEM_NAME_COLUMN = "item_name";
    public static final String ITEM_DESCRIPTION_COLUMN = "item_description";
    public static final String ITEM_QUANTITY_COLUMN = "item_quantity";
    public static final String ITEM_PRICE_COLUMN = "item_price";
    public static final String JOIN_BRAND_ID = "brand_id";
    public static final String JOIN_CATEGORY_LIST = "category_id";
    public static final String JOIN_ITEM_ID = "item_id";
    public static final String JOIN_TABLE_ITEM_CATEGORY = "item_category";

    public static final int ITEM_NAME_LENGTH = 60;
    public static final int ITEM_DESCRIPTION_LENGTH = 90;
}
