package io.honorius.api.data.repository;

import io.honorius.api.data.enttity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
