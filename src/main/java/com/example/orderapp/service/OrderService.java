package com.example.orderapp.service;

import com.example.orderapp.model.Order;
import com.example.orderapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(String productName) {
        Order order = new Order(null, productName, "PENDING");
        return orderRepository.save(order);
    }

    public Optional<Order> acceptOrder(Long id) {
        Optional<Order> orderOpt = orderRepository.findById(id);
        orderOpt.ifPresent(order -> {
            order.setStatus("ACCEPTED");
            orderRepository.save(order);
        });
        return orderOpt;
    }

    public List<Order> listOrders() {
        return orderRepository.findAll();
    }
}
