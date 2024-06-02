package io.honorius.api.config;

import io.honorius.api.data.repository.ProductRepository;
import io.honorius.api.data.repository.UserRepository;
import io.honorius.api.domain.caseuse.CreateProductCaseUse;
import io.honorius.api.domain.caseuse.CreateUserCaseUse;
import io.honorius.api.domain.mapper.ProductDomainMapper;
import io.honorius.api.domain.mapper.UserDomainMapper;
import io.honorius.api.utils.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateUserCaseUse createUserCaseUse(UserRepository userRepository, UserDomainMapper userDomainMapper, Validator validator){
        return new CreateUserCaseUse(userRepository, userDomainMapper, validator);
    }

    @Bean
    public CreateProductCaseUse createProductCaseUse(ProductRepository productRepository, ProductDomainMapper productDomainMapper, Validator validator){
        return new CreateProductCaseUse(productRepository, productDomainMapper, validator);
    }
}
