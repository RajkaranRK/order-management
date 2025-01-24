package com.rk.ordermanagement.service;

import com.rk.ordermanagement.entity.Order;
import com.rk.ordermanagement.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() ->
                new RuntimeException("Order not found with ID: " + orderId)
        );
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long orderId, Order orderDetails) {
        Order existingOrder = getOrderById(orderId);
        existingOrder.setUserId(orderDetails.getUserId());
        existingOrder.setPrice(orderDetails.getPrice());
        existingOrder.setAddress(orderDetails.getAddress());
        existingOrder.setMobileNumber(orderDetails.getMobileNumber());
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long orderId) {
        Order existingOrder = getOrderById(orderId);
        orderRepository.delete(existingOrder);
    }

}
