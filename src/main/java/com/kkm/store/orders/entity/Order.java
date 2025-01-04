package com.kkm.store.orders.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    
    @Field("orderId")
    private String orderId;
    
    private String product;
    private int quantity;

}