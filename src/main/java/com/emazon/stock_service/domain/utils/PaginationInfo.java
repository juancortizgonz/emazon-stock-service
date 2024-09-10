package com.emazon.stock_service.domain.utils;

public class PaginationInfo {
    private String sortBy;
    private boolean asc;
    private int pageSize;
    private int pageNumber;

    public PaginationInfo(String sortBy, boolean asc, int pageSize, int pageNumber) {
        this.sortBy = sortBy;
        this.asc = asc;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
