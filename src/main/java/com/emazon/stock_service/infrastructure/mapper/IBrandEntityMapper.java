package com.emazon.stock_service.infrastructure.mapper;

import com.emazon.stock_service.domain.model.Brand;
import com.emazon.stock_service.infrastructure.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IBrandEntityMapper {
    @Mapping(target = "name", source = "name")
    BrandEntity toBrandEntity(Brand brand);

    @Mapping(target = "name", source = "name")
    Brand toBrand(BrandEntity brandEntity);
}
