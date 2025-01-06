package com.kkm.store.orders.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kkm.store.orders.entity.Order;
import com.kkm.store.orders.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    private RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String INVENTORY_SERVICE_URL = "http://localhost:8084/api/inventory/";

    public Map<String, Object> getOrderById(String orderId) {
        System.out.println("OrderService.getOrderById() called");
        System.out.println("OrderService.getOrderById() called with orderId: " + orderId);

        String inventoryUrl = INVENTORY_SERVICE_URL + "Book";
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> response1 = restTemplate.exchange(inventoryUrl, HttpMethod.GET, null, Map.class);
        @SuppressWarnings("unchecked")
        Map<String, Object> inventoryDetails = response1.getBody();
        System.out.println("OrderController inventory deatails" + inventoryDetails);

        Order order = orderRepository.findByOrderId(orderId);
        System.out.println("OrderService.getOrderById() returned: " + order);
        Map<String, Object> response = new HashMap<>();
        response.put("order", order);
        return response;
    }

}
