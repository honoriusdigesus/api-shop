package io.honorius.api.domain.mapper;

import io.honorius.api.data.enttity.Order;
import io.honorius.api.domain.entity.OrderDomain;
import org.springframework.stereotype.Component;

@Component
public class OrderDomainMapper {
    private final OrderItemDomainMapper orderItemDomainMapper;

    public OrderDomainMapper(OrderItemDomainMapper orderItemDomainMapper) {
        this.orderItemDomainMapper = orderItemDomainMapper;
    }

    public OrderDomain toDomain(Order order) {
        return new OrderDomain(
                order.getComment(),
                order.getItems().stream().map(orderItemDomainMapper::toDomain).toList());
    }
    public Order toEntity(OrderDomain orderDomain) {
        return new Order(
                orderDomain.getComment(),
                orderDomain.getItems().stream().map(orderItemDomainMapper::toEntity).toList());
    }
}
