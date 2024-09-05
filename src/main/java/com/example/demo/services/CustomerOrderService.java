package com.example.demo.services;

import com.example.demo.entities.CustomerOrder;

import java.time.LocalDate;
import java.util.Optional;

public interface CustomerOrderService {
    CustomerOrder createOrder(Long id, String customerEmail, String customerAddress, LocalDate orderDate);
    CustomerOrder updateOrderAddress(Long id, String newAddress);
    void changeDeliveryStatus(Long id, String status);
    Optional<CustomerOrder> getOrderById(Long id);
}
