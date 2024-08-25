package com.emazon.stock_service.infrastructure.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageCreator {
    private PageCreator() {
        throw new AssertionError("Cannot instantiate pageable creator class");
    }

    public static Pageable createPageable(String order) {
        Sort sortBy = Sort.by("name");
        sortBy = "desc".equalsIgnoreCase(order) ? sortBy.descending() : sortBy.ascending();
        return PageRequest.of(0, 10, sortBy);
    }
}
