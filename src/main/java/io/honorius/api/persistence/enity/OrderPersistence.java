package io.honorius.api.persistence.enity;

import io.honorius.api.domain.entity.OrderItemDomain;
import io.honorius.api.enums.OrderStage;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.List;

public class OrderPersistence {
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    private String comment;

    @Enumerated(value = EnumType.STRING)
    private OrderStage state = OrderStage.PENDING;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserPersistence user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    List<OrderItemPersistence> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public OrderStage getState() {
        return state;
    }

    public void setState(OrderStage state) {
        this.state = state;
    }

    public UserPersistence getUser() {
        return user;
    }

    public void setUser(UserPersistence user) {
        this.user = user;
    }

    public List<OrderItemPersistence> getItems() {
        return items;
    }

    public void setItems(List<OrderItemPersistence> items) {
        this.items = items;
    }

    public OrderPersistence() {
    }

    public OrderPersistence(Integer id, LocalDateTime date, String comment, OrderStage state, UserPersistence user, List<OrderItemPersistence> items) {
        this.id = id;
        this.date = date;
        this.comment = comment;
        this.state = state;
        this.user = user;
        this.items = items;
    }

    public OrderPersistence(String comment, List<OrderItemPersistence> items) {
        this.comment = comment;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                ", state=" + state +
                ", user=" + user +
                ", items=" + items +
                '}';
    }
}
