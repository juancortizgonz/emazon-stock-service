package com.emazon.stock_service.infrastructure.config;

import com.emazon.stock_service.domain.api.IBrandServicePort;
import com.emazon.stock_service.domain.api.ICategoryServicePort;
import com.emazon.stock_service.domain.api.IItemServicePort;
import com.emazon.stock_service.domain.spi.IBrandPersistentPort;
import com.emazon.stock_service.domain.spi.ICategoryPersistentPort;
import com.emazon.stock_service.domain.spi.IItemPersistentPort;
import com.emazon.stock_service.domain.usecase.BrandUseCase;
import com.emazon.stock_service.domain.usecase.CategoryUseCase;
import com.emazon.stock_service.domain.usecase.ItemUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {

    @Bean
    public ICategoryServicePort categoryServicePort(ICategoryPersistentPort categoryPersistentPort) {
        return new CategoryUseCase(categoryPersistentPort);
    }

    @Bean
    public IBrandServicePort brandServicePort(IBrandPersistentPort brandPersistentPort) {
        return new BrandUseCase(brandPersistentPort);
    }

    @Bean
    public IItemServicePort itemServicePort(IItemPersistentPort itemPersistentPort) {
        return new ItemUseCase(itemPersistentPort);
    }
}
