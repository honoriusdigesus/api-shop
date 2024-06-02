package io.honorius.api.domain.entity;

import io.honorius.api.data.enttity.Order;
import io.honorius.api.data.enttity.Product;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;

public class OrderItemDomain {

    @JdbcTypeCode(Types.VARCHAR)
    private Integer id;
    @Column(nullable = false )
    private Integer quantity;
    ProductDomain product;
    OrderDomain order;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductDomain getProduct() {
        return product;
    }

    public void setProduct(ProductDomain product) {
        this.product = product;
    }

    public OrderDomain getOrder() {
        return order;
    }

    public void setOrder(OrderDomain order) {
        this.order = order;
    }

    public OrderItemDomain() {
    }

    public OrderItemDomain(Integer quantity, ProductDomain product) {
        this.quantity = quantity;
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderItemDomain{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                ", order=" + order +
                '}';
    }
}
