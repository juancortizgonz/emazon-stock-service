package com.emazon.stock_service.domain.utils;

public enum SortArgument {
    ITEM_NAME("itemName"), BRAND_NAME("brandName"), NUMBER_OF_CATEGORIES("numberOfCategories");

    private final String field;

    SortArgument(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
