package com.mritunjay.spring.training.project.inventory.service.service;

import com.mritunjay.spring.training.project.inventory.service.entity.Inventory;

import java.util.List;

public interface InventoryService {

    List<Inventory> getAllProducts();
    Inventory getProductById(Long id);
    Inventory createProduct(Inventory product);
    Inventory updateProduct(Long id, Inventory product);
    void deleteProduct(Long id);
}
