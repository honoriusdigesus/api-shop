package io.honorius.api.domain.entity;

import io.honorius.api.data.enttity.OrderItem;
import io.honorius.api.data.enttity.User;
import io.honorius.api.enums.OrderStage;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDomain {
    @JdbcTypeCode(Types.VARCHAR)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    private String comment;

    @Enumerated(value = EnumType.STRING)
    private OrderStage state = OrderStage.PENDING;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    List<OrderItemDomain> items;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItemDomain> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDomain> items) {
        this.items = items;
    }

    public OrderDomain() {
    }

    public OrderDomain(Integer id, LocalDateTime date, String comment, OrderStage state, User user, List<OrderItemDomain> items) {
        this.id = id;
        this.date = date;
        this.comment = comment;
        this.state = state;
        this.user = user;
        this.items = items;
    }

    public OrderDomain(String comment, List<OrderItemDomain> items) {
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
