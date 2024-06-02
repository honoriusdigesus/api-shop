package io.honorius.api.domain.caseuse;

import io.honorius.api.data.repository.ProductRepository;
import io.honorius.api.domain.entity.ProductDomain;
import io.honorius.api.domain.mapper.ProductDomainMapper;
import io.honorius.api.exception.exceptions.ProductNameException;
import io.honorius.api.exception.exceptions.ProductPriceStockException;
import io.honorius.api.utils.Validator;
import org.springframework.stereotype.Component;

@Component
public class CreateProductCaseUse {
    private final ProductRepository productRepository;
    private final ProductDomainMapper productDomainMapper;
    private final Validator validator;

    public CreateProductCaseUse(ProductRepository productRepository, ProductDomainMapper productDomainMapper, Validator validator) {
        this.productRepository = productRepository;
        this.productDomainMapper = productDomainMapper;
        this.validator = validator;
    }

    public void createProduct(ProductDomain productDomain) {
        if (validator.isValidStockOrPrice(productDomain.getStock(), productDomain.getPrice()) == false) {
            throw new ProductPriceStockException("Stock or price invalid");
        }
        if (validator.isValidName(productDomain.getName()) == false) {
            throw new ProductNameException("Name invalid");
        }
        productRepository.save(productDomainMapper.toEntity(productDomain));
    }
}
