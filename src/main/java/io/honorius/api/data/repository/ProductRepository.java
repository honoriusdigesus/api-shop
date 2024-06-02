package io.honorius.api.data.repository;

import io.honorius.api.data.enttity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
