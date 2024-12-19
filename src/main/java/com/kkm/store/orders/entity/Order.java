package com.kkm.store.orders.entity;

import org.springframework.data.annotation.Id;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Order {
    @Id
    private String id;
    private String orderId;
    private String product;
    private int quantity;

    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}