package com.kkm.store.orders.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkm.store.orders.entity.Order;
import com.kkm.store.orders.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Map<String, Object> getOrderById(String orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        Map<String, Object> response = new HashMap<>();
        response.put("order", order);
        return response;
    }
}
