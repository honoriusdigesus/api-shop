package io.honorius.api.config;

import io.honorius.api.data.repository.OrderRepository;
import io.honorius.api.data.repository.ProductRepository;
import io.honorius.api.data.repository.UserRepository;
import io.honorius.api.domain.caseuse.CreateOrderCaseUse;
import io.honorius.api.domain.caseuse.CreateProductCaseUse;
import io.honorius.api.domain.caseuse.CreateUserCaseUse;
import io.honorius.api.domain.mapper.OrderDomainMapper;
import io.honorius.api.domain.mapper.ProductDomainMapper;
import io.honorius.api.domain.mapper.UserDomainMapper;
import io.honorius.api.utils.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateUserCaseUse createUserCaseUse(UserRepository userRepository, UserDomainMapper userDomainMapper, Validator validator) {
        return new CreateUserCaseUse(userRepository, userDomainMapper, validator);
    }

    @Bean
    public CreateProductCaseUse createProductCaseUse(ProductRepository productRepository, ProductDomainMapper productDomainMapper, Validator validator) {
        return new CreateProductCaseUse(productRepository, productDomainMapper, validator);
    }

    @Bean
    public CreateOrderCaseUse createOrderCaseUse(OrderRepository orderRepository, UserRepository userRepository, OrderDomainMapper orderDomainMapper, ProductRepository productRepository, ProductDomainMapper productDomainMapper) {
        return new CreateOrderCaseUse(orderRepository, userRepository, orderDomainMapper, productRepository, productDomainMapper);
    }
}
