package com.kkm.store.orders.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kkm.store.orders.entity.Order;
import com.kkm.store.orders.repository.OrderRepository;

public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetOrderByIdSuccess() {
        Order mockOrder = new Order();
        mockOrder.setOrderId("123");
        mockOrder.setProduct("Test Product");
        mockOrder.setQuantity(10);

        when(orderRepository.findByOrderId("123")).thenReturn(mockOrder);

        Map<String, Object> response = orderService.getOrderById("123");

        assertNotNull(response);
        assertEquals(mockOrder, response.get("order"));

        verify(orderRepository, times(1)).findByOrderId("123");
    }

    @Test
    void testGetOrderByIdNotFound() {
        when(orderRepository.findByOrderId("456")).thenReturn(null);

        Map<String, Object> response = orderService.getOrderById("456");

        assertNotNull(response); // Empty map is returned
        assertNull(response.get("order"));

        verify(orderRepository, times(1)).findByOrderId("456");
    }
}
