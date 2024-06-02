package io.honorius.api.persistence.mapper;

import io.honorius.api.domain.entity.OrderDomain;
import io.honorius.api.persistence.enity.OrderPersistence;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderPersistenceMapper {
    private final OrderItemPersistenceMapper orderItemDomainMapper;

    public OrderPersistenceMapper(OrderItemPersistenceMapper orderItemDomainMapper) {
        this.orderItemDomainMapper = orderItemDomainMapper;
    }

    public OrderDomain toDomain(OrderPersistence order) {
        return new OrderDomain(order.getComment(), order.getItems().stream().map(orderItemDomainMapper::toDomain).collect(Collectors.toList()));
    }

    public OrderPersistence toPersistence(OrderDomain order) {
        return new OrderPersistence(order.getComment(), order.getItems().stream().map(orderItemDomainMapper::toPersistence).collect(Collectors.toList()));
    }
}