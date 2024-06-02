package io.honorius.api.persistence.enity;

import io.honorius.api.domain.caseuse.CreateOrderCaseUse;
import io.honorius.api.persistence.mapper.OrderPersistenceMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderPersistenceMapper orderPersistenceMapper;
    private final CreateOrderCaseUse createOrderCaseUse;

    public OrderController(OrderPersistenceMapper orderPersistenceMapper, CreateOrderCaseUse createOrderCaseUse) {
        this.orderPersistenceMapper = orderPersistenceMapper;
        this.createOrderCaseUse = createOrderCaseUse;
    }

    @PostMapping("/create/{idUser}")
    public void createOrder(@RequestBody OrderPersistence orderPersistence, @PathVariable Integer idUser) {
        createOrderCaseUse.createOrder(orderPersistenceMapper.toDomain(orderPersistence), idUser);
    }
}
