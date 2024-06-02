package io.honorius.api.persistence.mapper;

import io.honorius.api.domain.entity.OrderItemDomain;
import io.honorius.api.persistence.enity.OrderItemPersistence;
import org.springframework.stereotype.Component;

@Component
public class OrderItemPersistenceMapper {
    private final ProductPersistenceMapper productPersistenceMapper;

    public OrderItemPersistenceMapper(ProductPersistenceMapper productPersistenceMapper) {
        this.productPersistenceMapper = productPersistenceMapper;
    }

    public OrderItemPersistence toPersistence(OrderItemDomain orderItemDomain) {
        return new OrderItemPersistence(orderItemDomain.getQuantity(), productPersistenceMapper.toPersistence(orderItemDomain.getProduct()));
    }

    public OrderItemDomain toDomain(OrderItemPersistence orderItemPersistence) {
        return new OrderItemDomain(orderItemPersistence.getQuantity(), productPersistenceMapper.toDomain(orderItemPersistence.getProduct()));
    }
}
