package com.emazon.stock_service.infrastructure.config;

import com.emazon.stock_service.domain.api.ICategoryServicePort;
import com.emazon.stock_service.domain.spi.ICategoryPersistentPort;
import com.emazon.stock_service.domain.usecase.CategoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {

    @Bean
    public ICategoryServicePort categoryServicePort(ICategoryPersistentPort categoryPersistentPort) {
        return new CategoryUseCase(categoryPersistentPort);
    }
}
