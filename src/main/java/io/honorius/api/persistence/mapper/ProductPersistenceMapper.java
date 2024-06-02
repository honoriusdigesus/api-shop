package io.honorius.api.persistence.mapper;

import io.honorius.api.domain.entity.ProductDomain;
import io.honorius.api.persistence.enity.ProductPersistence;
import org.springframework.stereotype.Component;

@Component
public class ProductPersistenceMapper {

    public ProductDomain toDomain(ProductPersistence product) {
        return new ProductDomain(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getImage());
    }

    public ProductPersistence toPersistence(ProductDomain productDomain) {
        return new ProductPersistence(
                productDomain.getId(),
                productDomain.getName(),
                productDomain.getCategory(),
                productDomain.getDescription(),
                productDomain.getPrice(),
                productDomain.getStock(),
                productDomain.getImage());
    }
}
