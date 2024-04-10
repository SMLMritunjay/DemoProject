package com.mritunjay.spring.training.project.inventory.service.service.impl;

import com.mritunjay.spring.training.project.inventory.service.entity.Inventory;
import com.mritunjay.spring.training.project.inventory.service.repository.InventoryRepository;
import com.mritunjay.spring.training.project.inventory.service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository productRepository;
    @Override
    public List<Inventory> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Inventory getProductById(Long id) {
        Optional<Inventory> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Inventory createProduct(Inventory product) {
        return productRepository.save(product);
    }

    @Override
    public Inventory updateProduct(Long id, Inventory product) {
        product.setProductId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
}
