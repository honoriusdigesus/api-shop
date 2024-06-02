package io.honorius.api.config;

import io.honorius.api.domain.mapper.ProductDomainMapper;
import io.honorius.api.domain.mapper.UserDomainMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig {

    @Bean
    public UserDomainMapper userDomainMapper() {
        return new UserDomainMapper();
    }

    @Bean
    public ProductDomainMapper productDomainMapper() {
        return new ProductDomainMapper();
    }
}
