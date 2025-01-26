package com.rk.ordermanagement.controller;

import com.rk.ordermanagement.entity.Order;
import com.rk.ordermanagement.pojo.BaseRestResponse;
import com.rk.ordermanagement.pojo.Response;
import com.rk.ordermanagement.service.OrderService;
import com.rk.ordermanagement.utils.AppUtils;
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

    @GetMapping("/{orderId}")
    public Response<Object> getOrderById(@PathVariable("orderId") String orderId) {
        Response<Object> response = new Response<>();
        Order order =  orderService.getOrderById(orderId);
        AppUtils.setSuccessResponse(response);
        response.setData(order);
        return response;
    }

    @PostMapping
    public Response<Object> createOrder(@RequestBody Order order) {
        Response<Object> response = new Response<>();
        Order createdOrder =  orderService.createOrder(order);
        AppUtils.setSuccessResponse(response);
        response.setData(createdOrder);
        return response;
    }

    @PutMapping("/{orderId}")
    public Response<Object> updateOrder(@PathVariable("orderId") String orderId, @RequestBody Order orderDetails) {
        Response<Object> response = new Response<>();
        Order updatedOrder = orderService.updateOrder(orderId, orderDetails);
        AppUtils.setSuccessResponse(response);
        response.setData(updatedOrder);
        return response;
    }

    @DeleteMapping("/{orderId}")
    public Response<Object> deleteOrder(@PathVariable("id") String orderId) {
        Response<Object> response = new Response<>();
        Order deletedOrder  = orderService.deleteOrder(orderId);
        AppUtils.setSuccessResponse(response);
        response.setData(deletedOrder);
        return response;
    }
}
