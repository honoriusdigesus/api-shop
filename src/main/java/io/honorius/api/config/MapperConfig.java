package io.honorius.api.config;

import io.honorius.api.domain.mapper.OrderDomainMapper;
import io.honorius.api.domain.mapper.OrderItemDomainMapper;
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

    @Bean
    public OrderDomainMapper orderDomainMapper(OrderItemDomainMapper orderItemDomainMapper) {
        return new OrderDomainMapper(orderItemDomainMapper);
    }

    @Bean
    public OrderItemDomainMapper orderItemDomainMapper(ProductDomainMapper productDomainMapper) {
        return new OrderItemDomainMapper(productDomainMapper);
    }
}
