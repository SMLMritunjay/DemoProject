package com.mritunjay.spring.project.order.service.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long productId;
    private String productName;
    private int quantity;
    private  double price;
}
