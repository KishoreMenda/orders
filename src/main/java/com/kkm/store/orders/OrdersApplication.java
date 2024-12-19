package com.kkm.store.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrdersApplication {

	public static void main(String[] args) {
		System.out.println("OrdersApplication.main() called");
		SpringApplication.run(OrdersApplication.class, args);
	}

}
