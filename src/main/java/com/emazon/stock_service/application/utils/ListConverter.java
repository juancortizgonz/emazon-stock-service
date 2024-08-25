package com.emazon.stock_service.application.utils;

import com.emazon.stock_service.application.config.PaginationConfig;
import com.emazon.stock_service.application.dto.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class ListConverter {
    private ListConverter() {
        throw new AssertionError("Cannot instantiate list converter class");
    }

    public static <D> Page<D> listToPage(List<D> listModel, Integer pageNumber, Integer pageSize) {
        int effectivePageNumber = (pageNumber != null) ? pageNumber : PaginationConfig.getDefaultPageNumber();
        int effectivePageSize = (pageSize != null) ? pageSize : PaginationConfig.getDefaultPageSize();

        return new PageImpl<>(listModel, PageRequest.of(effectivePageNumber, effectivePageSize), listModel.size());
    }
}
