package com.example.demo.controllers;

import com.example.demo.entities.CustomerOrder;
import com.example.demo.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService orderService;

    @PostMapping
    public CustomerOrder createOrder(@RequestParam Long id, @RequestParam String customerEmail, @RequestParam String customerAddress, @RequestParam Date orderDate) {
        return orderService.createOrder(id, customerEmail, customerAddress, orderDate);
    }

    @PutMapping("/{id}/address")
    public CustomerOrder updateOrderAddress(@PathVariable Long id, @RequestParam String newAddress) {
        return orderService.updateOrderAddress(id, newAddress);
    }

    @PutMapping("/{id}/status")
    public void changeDeliveryStatus(@PathVariable Long id, @RequestParam String status) {
        orderService.changeDeliveryStatus(id, status);
    }

    @GetMapping("/{id}")
    public Optional<CustomerOrder> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
