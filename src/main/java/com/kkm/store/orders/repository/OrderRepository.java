package com.kkm.store.orders.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kkm.store.orders.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    Order findByOrderId(String orderId);
}