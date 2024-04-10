package com.mritunjay.spring.project.order.service.service;

import com.mritunjay.spring.project.order.service.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order placeOrder(Order order);
}
