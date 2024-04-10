package com.mritunjay.spring.project.order.service.service.impl;

import com.mritunjay.spring.project.order.service.entity.Order;
import com.mritunjay.spring.project.order.service.payload.Product;
import com.mritunjay.spring.project.order.service.repository.OrderRepository;
import com.mritunjay.spring.project.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final String PRODUCT_API_URL = "http://localhost:8080/api/inventory";

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order  placeOrder(Order order) {
        // Get product details from the product service
        Product product = restTemplate.getForObject(PRODUCT_API_URL, Product.class, order.getProductId());
// Check if product is available and quantity is sufficient
        if (product != null && product.getQuantity() >= order.getQuantity()) {
// Update product quantity
            int updatedQuantity = product.getQuantity() - order.getQuantity();
                        product.setQuantity(updatedQuantity);
// Update product details in the product service
            restTemplate.put(PRODUCT_API_URL, new Product(order.getProductId(), product.getProductName(),updatedQuantity, product.getPrice()));
// Set order status to "Placed" and return the order
            order.setStatus("Placed");
            return order;
        }
        else
        {
// Set order status to "Failed" and return null
            order.setStatus(
                    "Failed"
            );
            return
                    null;
        }
    }
}
