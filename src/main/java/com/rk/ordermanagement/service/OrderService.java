package com.rk.ordermanagement.service;

import com.rk.ordermanagement.entity.Order;
import com.rk.ordermanagement.enums.ErrorCodes;
import com.rk.ordermanagement.exception.RestServiceException;
import com.rk.ordermanagement.pojo.Response;
import com.rk.ordermanagement.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String orderId) {
        return orderRepository.findByOrderId(orderId).orElseThrow(() ->
                new RestServiceException(ErrorCodes.NOT_FOUND.getCode())
        );
    }

    public Order createOrder(Order order) {
        return orderRepository.findByOrderId(order.getOrderId())
                .orElseGet(() -> orderRepository.save(order));
    }

    public Order updateOrder(String orderId, Order orderDetails) {
        Order existingOrder = getOrderById(orderId);
        existingOrder.setUserId(orderDetails.getUserId());
        existingOrder.setPrice(orderDetails.getPrice());
        existingOrder.setAddress(orderDetails.getAddress());
        existingOrder.setMobileNumber(orderDetails.getMobileNumber());
        existingOrder.setOrderState(orderDetails.getOrderState());
        return orderRepository.save(existingOrder);
    }

    public Order deleteOrder(String orderId) {
        Order existingOrder = getOrderById(orderId);
        orderRepository.delete(existingOrder);
        return existingOrder;
    }

}
