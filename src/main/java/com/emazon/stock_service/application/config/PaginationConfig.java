package com.emazon.stock_service.application.config;

public class PaginationConfig {
    private PaginationConfig() {
    }

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 10;

    public static int getDefaultPageNumber() {
        return DEFAULT_PAGE_NUMBER;
    }

    public static int getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }
}
