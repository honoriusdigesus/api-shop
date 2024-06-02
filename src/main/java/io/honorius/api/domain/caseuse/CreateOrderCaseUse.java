package io.honorius.api.domain.caseuse;

import io.honorius.api.data.enttity.OrderItem;
import io.honorius.api.data.repository.OrderRepository;
import io.honorius.api.data.repository.ProductRepository;
import io.honorius.api.data.repository.UserRepository;
import io.honorius.api.domain.entity.OrderDomain;
import io.honorius.api.domain.mapper.OrderDomainMapper;
import io.honorius.api.domain.mapper.ProductDomainMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreateOrderCaseUse {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    private final OrderDomainMapper orderDomainMapper;
    private final ProductDomainMapper productDomainMapper;

    public CreateOrderCaseUse(
            OrderRepository orderRepository,
            UserRepository userRepository,
            OrderDomainMapper orderDomainMapper,
            ProductRepository productRepository,
            ProductDomainMapper productDomainMapper
    ) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderDomainMapper = orderDomainMapper;
        this.productRepository = productRepository;
        this.productDomainMapper = productDomainMapper;
    }

    public void createOrder(OrderDomain orderDomain, Integer idUser) {
        System.out.println("User recieved: " + orderDomain.getUser());
        var myOrder = orderDomainMapper.toEntity(orderDomain);
        myOrder.setComment(orderDomain.getComment());

        List<OrderItem> items = orderDomain.getItems().stream().map(item -> {
            OrderItem orderItems = new OrderItem();
            orderItems.setOrder(myOrder);
            orderItems.setQuantity(item.getQuantity());
            orderItems.setProduct(productRepository.getById(item.getProduct().getId()));
            return orderItems;
        }).collect(Collectors.toList());

        myOrder.setItems(items);
        myOrder.setUser(userRepository.getById(idUser));
        orderRepository.save(myOrder);
        System.out.println("Order created successfully! with user" +myOrder.getUser());
    }
}