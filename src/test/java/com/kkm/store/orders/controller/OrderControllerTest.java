// package com.kkm.store.orders.controller;

// import com.kkm.store.orders.service.OrderService;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;

// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @WebMvcTest(OrderController.class)
// class OrderControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private OrderService orderService;

//     @Test
//     void testGetOrderByIdSuccess() throws Exception {
//         // Mock the service response
//         Order mockOrder = new Order("6762fe924ccd692ef0fbea48", "123", "Book", "2");
//         when(orderService.getOrderById("123")).thenReturn(mockOrder);

//         // Perform the GET request
//         mockMvc.perform(get("/api/orders/123")
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.orderId").value("123"))
//                 .andExpect(jsonPath("$.product").value("Book"))
//                 .andExpect(jsonPath("$.quantity").value("2"));
//     }

//     @Test
//     void testGetOrderByIdNotFound() throws Exception {
//         // Mock the service response for not found
//         when(orderService.getOrderById("999")).thenReturn(null);

//         // Perform the GET request
//         mockMvc.perform(get("/api/orders/999")
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isNotFound());
//     }
// }
