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
        System.out.println("OrderService.getOrderById() called");
        System.out.println("OrderService.getOrderById() called with orderId: " + orderId);

        Order order = orderRepository.findByOrderId(orderId);
        System.out.println("OrderService.getOrderById() returned: " + order);
        Map<String, Object> response = new HashMap<>();
        response.put("order", order);
        return response;
    }
}
