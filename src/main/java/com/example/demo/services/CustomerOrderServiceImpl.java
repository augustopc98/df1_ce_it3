package com.example.demo.services;

import com.example.demo.entities.CustomerOrder;
import com.example.demo.repositories.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderRepository orderRepository;

    @Override
    public CustomerOrder createOrder(Long id, String customerEmail, String customerAddress, LocalDate orderDate) {
        CustomerOrder order = new CustomerOrder(id, customerEmail, customerAddress, orderDate);
        return orderRepository.save(order);
    }

    @Override
    public CustomerOrder updateOrderAddress(Long id, String newAddress) {
        Optional<CustomerOrder> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            CustomerOrder order = orderOptional.get();
            order.setCustomerAddress(newAddress);
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public void changeDeliveryStatus(Long id, String status) {
        Optional<CustomerOrder> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            CustomerOrder order = orderOptional.get();
            order.updateDeliveryStatus(status);
            orderRepository.save(order);
        }
    }

    @Override
    public Optional<CustomerOrder> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
}
