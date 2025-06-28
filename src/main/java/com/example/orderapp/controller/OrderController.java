package com.example.orderapp.controller;

import com.example.orderapp.model.Order;
import com.example.orderapp.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // POST /orders
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestParam String productName) {
        Order order = orderService.createOrder(productName);
        return ResponseEntity.ok(order);
    }

    // PUT /orders/{id}/accept
    @PutMapping("/{id}/accept")
    public ResponseEntity<Order> acceptOrder(@PathVariable Long id) {
        return orderService.acceptOrder(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /orders
    @GetMapping
    public ResponseEntity<List<Order>> listOrders() {
        return ResponseEntity.ok(orderService.listOrders());
    }
}
