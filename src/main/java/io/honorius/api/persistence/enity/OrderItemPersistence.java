package io.honorius.api.persistence.enity;

import io.honorius.api.data.enttity.Product;
import io.honorius.api.domain.entity.OrderDomain;
import jakarta.persistence.Column;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;

public class OrderItemPersistence {

    @JdbcTypeCode(Types.VARCHAR)
    private Integer id;
    @Column(nullable = false )
    private Integer quantity;
    ProductPersistence product;
    OrderPersistence order;


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

    public ProductPersistence getProduct() {
        return product;
    }

    public void setProduct(ProductPersistence product) {
        this.product = product;
    }

    public OrderPersistence getOrder() {
        return order;
    }

    public void setOrder(OrderPersistence order) {
        this.order = order;
    }

    public OrderItemPersistence() {
    }

    public OrderItemPersistence(Integer quantity, ProductPersistence product) {
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
