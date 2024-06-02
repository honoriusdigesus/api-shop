package io.honorius.api.domain.mapper;

import io.honorius.api.data.enttity.OrderItem;
import io.honorius.api.domain.entity.OrderItemDomain;
import org.springframework.stereotype.Component;

@Component
public class OrderItemDomainMapper {
    private final ProductDomainMapper productDomainMapper;

    public OrderItemDomainMapper(ProductDomainMapper productDomainMapper) {
        this.productDomainMapper = productDomainMapper;
    }

    public OrderItem toEntity(OrderItemDomain orderItemDomain) {
        return new OrderItem(
                orderItemDomain.getQuantity(),
                productDomainMapper.toEntity(orderItemDomain.getProduct()));
    }

    public OrderItemDomain toDomain(OrderItem orderItem) {
        return new OrderItemDomain(
                orderItem.getQuantity(),
                productDomainMapper.toDomain(orderItem.getProduct()));
    }

}
