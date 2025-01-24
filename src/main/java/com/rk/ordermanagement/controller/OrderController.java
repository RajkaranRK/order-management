package com.rk.ordermanagement.controller;

import com.rk.ordermanagement.entity.Order;
import com.rk.ordermanagement.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/orders")
@RestController
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable("id") Long orderId, @RequestBody Order orderDetails) {
        return orderService.updateOrder(orderId, orderDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable("id") Long orderId) {
        orderService.deleteOrder(orderId);
        return "Order with ID " + orderId + " has been deleted!";
    }
}
