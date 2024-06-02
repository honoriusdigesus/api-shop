package io.honorius.api.domain.mapper;

import io.honorius.api.data.enttity.Product;
import io.honorius.api.domain.entity.ProductDomain;
import org.springframework.stereotype.Component;

@Component
public class ProductDomainMapper {

    public ProductDomain toDomain(Product product) {
        return new ProductDomain(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getImage());
    }

    public Product toEntity(ProductDomain productDomain) {
        return new Product(
                productDomain.getId(),
                productDomain.getName(),
                productDomain.getCategory(),
                productDomain.getDescription(),
                productDomain.getPrice(),
                productDomain.getStock(),
                productDomain.getImage());
    }
}
