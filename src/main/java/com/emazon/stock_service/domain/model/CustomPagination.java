package com.emazon.stock_service.domain.model;

import java.util.List;

public class CustomPagination<T> {
    private List<T> data;
    private Long elements;
    private int pages;
    private int currentPage;
    private boolean asc;
    private boolean empty;

    public CustomPagination(List<T> data, Long elements, int pages, int currentPage, boolean asc) {
        this.data = data;
        this.elements = elements;
        this.pages = pages;
        this.currentPage = currentPage;
        this.asc = asc;
        this.empty = data.isEmpty();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getElements() {
        return elements;
    }

    public void setElements(Long elements) {
        this.elements = elements;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
