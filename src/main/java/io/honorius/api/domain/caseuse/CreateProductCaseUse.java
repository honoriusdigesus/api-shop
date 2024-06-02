package io.honorius.api.domain.caseuse;

import io.honorius.api.data.repository.ProductRepository;
import io.honorius.api.domain.entity.ProductDomain;
import io.honorius.api.domain.mapper.ProductDomainMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateProductCaseUse {
    private final ProductRepository productRepository;
    private final ProductDomainMapper productDomainMapper;

    public CreateProductCaseUse(ProductRepository productRepository, ProductDomainMapper productDomainMapper) {
        this.productRepository = productRepository;
        this.productDomainMapper = productDomainMapper;
    }

    public void createProduct(ProductDomain productDomain) {
        productRepository.save(productDomainMapper.toEntity(productDomain));
    }
}
